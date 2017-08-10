package com.pme.plus.pmeplus.Entity;

import com.pme.plus.pmeplus.Entity.UDT.Address;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by gnkali on 6/20/17.
 */
@Entity(name = "Shop")
@Table(name = "Shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idShop;

    @Version
    private int version;

    private Address address;
    private String phone;
    private String	email;
    private Date registrationDate;

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
