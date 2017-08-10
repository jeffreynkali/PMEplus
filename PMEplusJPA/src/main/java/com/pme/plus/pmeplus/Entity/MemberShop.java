package com.pme.plus.pmeplus.Entity;

import com.pme.plus.pmeplus.Entity.UDT.MemberShopId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by gnkali on 6/21/17.
 */
@Entity(name = "MemberShop")
@Table(name = "MemberShop")
public class MemberShop {

    @EmbeddedId
    private MemberShopId id;

    @Version
    private int version;
    private String cardNumber;
    private long points;
    private Date registrationDate;

    public MemberShopId getId() {
        return id;
    }

    public void setId(MemberShopId id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
