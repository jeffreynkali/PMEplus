package com.pme.plus.pmeplus.Entity;

import com.pme.plus.pmeplus.Entity.UDT.TransactionShopId;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by gnkali on 6/21/17.
 */
@Entity(name = "TransactionShop")
@Table(name = "TransactionShop")
public class TransactionShop {

    @EmbeddedId
    private TransactionShopId id;

    @Version
    private int version;

    private Date transactionTimestamp;
    private int quantity;

    public TransactionShopId getId() {
        return id;
    }

    public void setId(TransactionShopId id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Date transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
