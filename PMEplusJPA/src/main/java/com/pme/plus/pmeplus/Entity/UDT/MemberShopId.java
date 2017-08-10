package com.pme.plus.pmeplus.Entity.UDT;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Created by gnkali on 7/29/17.
 */
@Embeddable
public class MemberShopId implements Serializable {

    @Column(name = "idMember")
    private int idMember;

    @Column(name = "idShop")
    private int idShop;

    public MemberShopId() {

    }

    public MemberShopId(int idMember, int idShop) {
        this.idMember = idMember;
        this.idShop = idShop;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
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

        MemberShopId that = (MemberShopId) o;

        if (getIdMember() != that.getIdMember()) return false;
        return getIdShop() == that.getIdShop();
    }

    @Override
    public int hashCode() {
        int result = getIdMember();
        result = 31 * result + getIdShop();
        return result;
    }
}
