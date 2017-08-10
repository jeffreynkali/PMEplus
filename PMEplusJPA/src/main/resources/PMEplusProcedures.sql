﻿--Stored procedures to interact with table Member

--return all the tuples stored in the Member table (all the members)
CREATE OR REPLACE FUNCTION PMEplus.getAllMembers() RETURNS SETOF PMEplus.Member AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.Member';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the Member table based on its idMember
CREATE OR REPLACE FUNCTION PMEplus.getMemberByID( id INT) RETURNS SETOF PMEplus.Member AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.Member WHERE idMember = ' || id ;
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the Member table based on its email address
CREATE OR REPLACE FUNCTION PMEplus.getMemberByEmail( emailAddress VARCHAR(70)) RETURNS SETOF PMEplus.Member AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.Member WHERE email = ' || emailAddress ;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing members
CREATE OR REPLACE FUNCTION PMEplus.getCountOfMembers() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfMembers FROM PMEplus.Member INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the Member table
CREATE OR REPLACE FUNCTION PMEplus.createMember(firstname VARCHAR(20), lastname VARCHAR(20), email VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.Member(firstName, lastname, email) VALUES (firstname, lastname, email);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the Member table based on the idMember
CREATE OR REPLACE FUNCTION PMEplus.deleteMemberByID(id INT) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.Member WHERE idMember = id;
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the Member table based on the email address
CREATE OR REPLACE FUNCTION PMEplus.deleteMemberByEmail(emailAddress VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.Member WHERE email = emailAddress;
END;
$$
LANGUAGE 'plpgsql';

--update the email address of a specific tuple of the Member table

CREATE OR REPLACE FUNCTION PMEplus.updateMemberEmail(id INT, emailAddress VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Member
	SET email = emailAddress
	WHERE idMember = id;
END;
$$
LANGUAGE plpgsql;

--update the  firstname of a specific tuple of the Member table

CREATE OR REPLACE FUNCTION PMEplus.updateMemberFirstname(id INT, fname VARCHAR(60)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Member
	SET firstname = fname
	WHERE idMember = id;
END;
$$
LANGUAGE plpgsql;

--update the lastname of a specific tuple of the Member table

CREATE OR REPLACE FUNCTION PMEplus.updateMemberLastname(id INT, lname VARCHAR(60)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Member
	SET lastname = lname
	WHERE idMember = id;
END;
$$
LANGUAGE plpgsql;

--update a specific tuple of the Member table

CREATE OR REPLACE FUNCTION PMEplus.updateMemberByID(id INT, fname VARCHAR(60), lname VARCHAR(60), emailAddress VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Member
	SET firstname = fname, lastname = lname, email = emailAddress
	WHERE idMember = id;
END;
$$
LANGUAGE plpgsql;








--Stored procedures to interact with table ShopRepository

--return all the tuples stored in the ShopRepository table (all the shops)
CREATE OR REPLACE FUNCTION PMEplus.getAllShops() RETURNS SETOF PMEplus.Shop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.ShopRepository';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the ShopRepository table based on its idShop
CREATE OR REPLACE FUNCTION PMEplus.getShopByID( id INT) RETURNS SETOF PMEplus.Shop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.ShopRepository WHERE idShop = ' || id ;
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the ShopRepository table based on its email address
CREATE OR REPLACE FUNCTION PMEplus.getShopByEmail( emailAddress VARCHAR(70)) RETURNS SETOF PMEplus.Shop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.ShopRepository WHERE email = ' || emailAddress ;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing shops
CREATE OR REPLACE FUNCTION PMEplus.getCountOfShops() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfShops FROM PMEplus.Shop INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the ShopRepository table
CREATE OR REPLACE FUNCTION PMEplus.createShop(address Address, phone VARCHAR(10), email VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.Shop(address, phone, email) VALUES (address, phone, email);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the ShopRepository table based on the idShop
CREATE OR REPLACE FUNCTION PMEplus.deleteShopByID(id INT) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.Shop WHERE idShop = id;
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the ShopRepository table based on the email address
CREATE OR REPLACE FUNCTION PMEplus.deleteShopByEmail(emailAddress VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.Shop WHERE email = emailAddress;
END;
$$
LANGUAGE 'plpgsql';

--update the email address of a specific tuple of the ShopRepository table

CREATE OR REPLACE FUNCTION PMEplus.updateShopEmail(id INT, emailAddress VARCHAR(70)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Shop
	SET email = emailAddress
	WHERE idShop = id;
END;
$$
LANGUAGE plpgsql;









--Stored procedures to interact with table Product

--return all the tuples stored in the Product table (all the products)
CREATE OR REPLACE FUNCTION PMEplus.getAllProducts() RETURNS SETOF PMEplus.Product AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.Product';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the Product table based on its idProduct
CREATE OR REPLACE FUNCTION PMEplus.getProductByID( id INT) RETURNS SETOF PMEplus.Product AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.Product WHERE idProduct = ' || id ;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing products
CREATE OR REPLACE FUNCTION PMEplus.getCountOfProducts() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfProducts FROM PMEplus.Product INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the Product table
CREATE OR REPLACE FUNCTION PMEplus.createProduct(productName VARCHAR(50), category VARCHAR(50) ) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.Product(name, category) VALUES (productName, category);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the Product table based on the idProduct
CREATE OR REPLACE FUNCTION PMEplus.deleteProductByID(id INT) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.Product WHERE idProduct = id;
END;
$$
LANGUAGE 'plpgsql';

--update the name of a specific tuple of the Product table

CREATE OR REPLACE FUNCTION PMEplus.updateProductName(id INT, productName VARCHAR(50)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.Product
	SET name = productName
	WHERE idProduct = id;
END;
$$
LANGUAGE plpgsql;










--Stored procedures to interact with table MemberShop

--return all the tuples stored in the MemberShop table (all the MemberShops)
CREATE OR REPLACE FUNCTION PMEplus.getAllMemberShops() RETURNS SETOF PMEplus.MemberShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.MemberShop';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the MemberShop table based on its idMember, idShop
CREATE OR REPLACE FUNCTION PMEplus.getMemberShopByIDs(idM INT, idS INT) RETURNS SETOF PMEplus.MemberShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.MemberShop WHERE idMember = ' || idM || ' AND idShop = ' || idS ;
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the MemberShop table based on its cardNumber
CREATE OR REPLACE FUNCTION PMEplus.getMemberShopByCardNumber(cn VARCHAR(30)) RETURNS SETOF PMEplus.MemberShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.MemberShop WHERE cardNumber = ' || cn ;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing MemberShop
CREATE OR REPLACE FUNCTION PMEplus.getCountOfMemberShops() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfMemberShops FROM PMEplus.MemberShop INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the MemberShop table
CREATE OR REPLACE FUNCTION PMEplus.createMemberShop(idM INT, idS INT, cnum VARCHAR(30), pts BIGINT ) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.MemberShop(idMember, idShop, cardNumber, points) VALUES (idM, idS, cnum, pts);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the MemberShop table based on the (idMember, idShop)
CREATE OR REPLACE FUNCTION PMEplus.deleteMemberShopByIDs(idM INT, idS INT) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.MemberShop WHERE idMember = idM AND idShop = idS;
END;
$$
LANGUAGE 'plpgsql';

--update the points of a specific tuple of the MemberShop table

CREATE OR REPLACE FUNCTION PMEplus.updateMemberShopPoints(idM INT, idS INT, pts BIGINT) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.MemberShop
	SET points = pts
	WHERE idMember = idM AND idShop = idS;
END;
$$
LANGUAGE plpgsql;









--Stored procedures to interact with table ProductShop

--return all the tuples stored in the ProductShop table (all the ProductShops)
CREATE OR REPLACE FUNCTION PMEplus.getAllProductShops() RETURNS SETOF PMEplus.ProductShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.ProductShop';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the ProductShop table based on its idProduct, idShop
CREATE OR REPLACE FUNCTION PMEplus.getProductShopByIDs(idP INT, idS INT) RETURNS SETOF PMEplus.ProductShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.ProductShop WHERE idProduct = ' || idP || ' AND idShop = ' || idS ;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing ProductShop
CREATE OR REPLACE FUNCTION PMEplus.getCountOfProductShops() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfProductShops FROM PMEplus.ProductShop INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the ProductShop table
CREATE OR REPLACE FUNCTION PMEplus.createProductShop(idP INT, idS INT, productName VARCHAR(50), start_t TIMESTAMP, end_t TIMESTAMP, ppi INT ) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.ProductShop(idProduct, idShop, name, promotionStartTimestamp, promotionEndTimestamp, pointsPerItem) VALUES (idP, idS, productName, start_t, end_t, ppi);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the ProductShop table based on the (idProduct, idShop)
CREATE OR REPLACE FUNCTION PMEplus.deleteProductShopByIDs(idP INT, idS INT) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.ProductShop WHERE idProduct = idP AND idShop = idS;
END;
$$
LANGUAGE 'plpgsql';

--update the pointsPerItem of a specific tuple of the ProductShop table

CREATE OR REPLACE FUNCTION PMEplus.updateProducShopPointsPerItem(idP INT, idS INT, ppi INT) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.ProductShop
	SET pointsPerItem = ppi
	WHERE idProduct = idP AND idShop = idS;
END;
$$
LANGUAGE plpgsql;

--update the name of a specific tuple of the ProductShop table

CREATE OR REPLACE FUNCTION PMEplus.updateProducShopName(idP INT, idS INT, ne VARCHAR(50)) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.ProductShop
	SET name = ne
	WHERE idProduct = idP AND idShop = idS;
END;
$$
LANGUAGE plpgsql;










--Stored procedures to interact with table TransactionShop

--return all the tuples stored in the TransactionShop table (all the Transactions)
CREATE OR REPLACE FUNCTION PMEplus.getAllTransactionShops() RETURNS SETOF PMEplus.TransactionShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.TransactionShop';
END;
$$
LANGUAGE 'plpgsql';

--return a specific tuple from the TransactionShop table based on its idProduct, idShop, idMember, transactionTimestamp
CREATE OR REPLACE FUNCTION PMEplus.getTransactionShopByIDs(idP INT, idS INT, idM INT, trans_t timestamp) RETURNS SETOF PMEplus.TransactionShop AS
$$
BEGIN
    RETURN QUERY EXECUTE
    'SELECT * FROM PMEplus.TransactionShop WHERE idProduct = ' || idP || ' AND idShop = ' || idS || ' AND idMember = ' || idM || ' AND transactionTimestamp = ' || trans_t;
END;
$$
LANGUAGE 'plpgsql';

--return the count of existing TransactionShop
CREATE OR REPLACE FUNCTION PMEplus.getCountOfProducts() RETURNS INTEGER AS
$$
DECLARE result INTEGER;
BEGIN
	SELECT COUNT(*) AS NumberOfTransactionShops FROM PMEplus.TransactionShop INTO result;
    RETURN result;
END;
$$
LANGUAGE 'plpgsql';

--insert a new tuple into the TransactionShop table
CREATE OR REPLACE FUNCTION PMEplus.createTransactionShop(idP INT, idS INT, idM INT, qty INT ) RETURNS VOID AS
$$
BEGIN
    INSERT INTO PMEplus.TransactionShop(idProduct, idShop, idMember, quantity) VALUES (idP, idS, idM, qty);
END;
$$
LANGUAGE 'plpgsql';

--delete a tuple from the TransactionShop table based on the (idProduct, idShop, idMember, transactionTimestamp)
CREATE OR REPLACE FUNCTION PMEplus.deleteTransactionShopByIDs(idP INT, idS INT, idM INT, trans_t TIMESTAMP) RETURNS VOID AS
$$
BEGIN
    DELETE FROM PMEplus.TransactionShop WHERE idProduct = idP AND idShop = idS AND idMember = idM AND transactionTimestamp = trans_t;
END;
$$
LANGUAGE 'plpgsql';

--update the quantity of a specific tuple of the TransactionShop table

CREATE OR REPLACE FUNCTION PMEplus.updateTransactionShopQuantity(idP INT, idS INT, idM INT, trans_t TIMESTAMP, qty INT) RETURNS VOID AS
$$
BEGIN
	UPDATE PMEplus.TransactionShop
	SET quantity = qty
	WHERE idProduct = idP AND idShop = idS AND idMember = idM AND transactionTimestamp = trans_t;
END;
$$
LANGUAGE plpgsql;






















-----------------------TRIGGER TO COMPUTE the new total of points each time a new transaction occurs---------

--Trigger on table TransactionShop

CREATE OR REPLACE FUNCTION PMEplus.points_update_after_transaction() RETURNS trigger AS
$points_update_after_transaction$
    BEGIN
        -- Check that idProduct, idShop, idMember and quantity are given
        IF NEW.idProduct IS NULL THEN
            RAISE EXCEPTION 'idProduct cannot be null';
        END IF;
        IF NEW.idShop IS NULL THEN
            RAISE EXCEPTION 'idShop cannot be null';
        END IF;
        IF NEW.idMember IS NULL THEN
            RAISE EXCEPTION 'idMember cannot be null';
        END IF;
        IF NEW.quantity IS NULL THEN
            RAISE EXCEPTION '% cannot have a null quantity purchased for the product', NEW.idProduct;
        END IF;

        -- The contribution cannot be negative
        IF NEW.quantity < 0 THEN
            RAISE EXCEPTION '% cannot have a negative quantity for the product', NEW.idProduct;
        END IF;

	--update the points value
	UPDATE PMEplus.MemberShop
	SET points = points + NEW.quantity * (
	                                        SELECT pointsPerItem
	                                        FROM PMEplus.ProductShop
	                                        WHERE idProduct = NEW.idProduct AND idShop = NEW.idShop)
	WHERE idProduct = NEW.idProduct AND idShop = NEW.idShop AND idMember = NEW.idMember;
	RETURN NEW;
    END;
$points_update_after_transaction$
LANGUAGE plpgsql;

--The trigger is activated after insert or update to make sure that the row was valid
CREATE TRIGGER points_update_after_transaction AFTER INSERT OR UPDATE ON PMEplus.TransactionShop
    FOR EACH ROW EXECUTE PROCEDURE PMEplus.points_update_after_transaction();

