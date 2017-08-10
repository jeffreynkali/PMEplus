package com.pme.plus.pmeplus.Entity.UDT;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by gnkali on 6/20/17.
 */
@Embeddable
public class Address {
    private String street;
    private String city;
    private String province;
    private String postalCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
