package com.pme.plus.pmeplus.Entity.UDT;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by gnkali on 7/29/17.
 */
@Embeddable
public class ProductShopId implements Serializable{

    @Column(name = "idProduct")
    private int idProduct;

    @Column(name = "idShop")
    private int idShop;

    public ProductShopId() {

    }

    public ProductShopId(int idProduct, int idShop) {
        this.idProduct = idProduct;
        this.idShop = idShop;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductShopId that = (ProductShopId) o;

        if (getIdProduct() != that.getIdProduct()) return false;
        return getIdShop() == that.getIdShop();
    }

    @Override
    public int hashCode() {
        int result = getIdProduct();
        result = 31 * result + getIdShop();
        return result;
    }
}
