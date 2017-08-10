DROP SCHEMA IF EXISTS PMEplus CASCADE;
CREATE SCHEMA PMEplus;

--Declaration of all UDTs : Domains and Types
CREATE EXTENSION citext;
CREATE DOMAIN   Email AS citext
  CHECK ( value ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );

CREATE DOMAIN PostalCode AS VARCHAR
  CHECK ( value ~ '^[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]$');

CREATE DOMAIN Phone AS VARCHAR
  CHECK ( value ~ '^[0-9]{10}');

CREATE TYPE Address AS (street VARCHAR(90), city VARCHAR(90), province VARCHAR(40), postalCode PostalCode );

CREATE TABLE IF NOT EXISTS PMEplus.Member (
	idMember	SERIAL,
	firstname	VARCHAR(60) NOT NULL,
	lastname    VARCHAR(60) NOT NULL,
	email		Email UNIQUE NOT NULL,
	PRIMARY KEY (IDMember)
);

CREATE TABLE IF NOT EXISTS PMEplus.Shop (
	idShop	SERIAL,
	address Address NOT NULL,
	phone	Phone UNIQUE NOT NULL,
	email	Email UNIQUE NOT NULL,
	registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (idShop)
);

CREATE TABLE IF NOT EXISTS PMEplus.Product (
    idProduct SERIAL,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY (idProduct)
);


CREATE TABLE IF NOT EXISTS PMEplus.ProductShop (
    idProduct INT NOT NULL,
    idShop INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    promotionStartTimestamp TIMESTAMP NOT NULL,
    promotionEndTimestamp TIMESTAMP NOT NULL,
    pointsPerItem INT NOT NULL,
    PRIMARY KEY (idProduct, idShop),
    FOREIGN KEY (idProduct) REFERENCES PMEplus.Product(idProduct) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (idShop) REFERENCES PMEplus.Shop(idShop) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PMEplus.MemberShop (
    idMember INT NOT NULL,
    idShop INT NOT NULL,
    cardNumber  VARCHAR(30) UNIQUE NOT NULL,
    points BIGINT DEFAULT 0, --by default a member of a shop will start with 0 points
    registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (idMember, idShop),
    FOREIGN KEY (idMember) REFERENCES PMEplus.Member(idMember) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (idShop) REFERENCES PMEplus.Shop(idShop) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PMEplus.TransactionShop (
    idProduct INT NOT NULL,
    idShop INT NOT NULL,
    idMember INT NOT NULL,
    transactionTimestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    quantity INT NOT NULL,
    PRIMARY KEY (idProduct, idShop, idMember, transactionTimestamp),
    FOREIGN KEY (idProduct) REFERENCES PMEplus.Product(idProduct) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (idShop) REFERENCES PMEplus.Shop(idShop) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (idMember) REFERENCES PMEplus.Member(idMember) ON UPDATE CASCADE ON DELETE CASCADE
);