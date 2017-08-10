package com.pme.plus.pmeplus.Entity.UDT;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by gnkali on 7/29/17.
 */
@Embeddable
public class TransactionShopId implements Serializable {

    @Column(name = "idProduct")
    private int idProduct;

    @Column(name = "idShop")
    private int idShop;

    @Column(name = "idMember")
    private int idMember;

    public TransactionShopId() {

    }

    public TransactionShopId(int idProduct, int idShop, int idMember) {
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.idMember = idMember;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionShopId that = (TransactionShopId) o;

        if (getIdProduct() != that.getIdProduct()) return false;
        if (getIdShop() != that.getIdShop()) return false;
        return getIdMember() == that.getIdMember();
    }

    @Override
    public int hashCode() {
        int result = getIdProduct();
        result = 31 * result + getIdShop();
        result = 31 * result + getIdMember();
        return result;
    }
}
