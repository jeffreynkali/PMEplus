package com.pme.plus.pmeplus.Entity;

import com.pme.plus.pmeplus.Entity.UDT.ProductShopId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by gnkali on 6/21/17.
 */
@Entity(name = "ProductShop")
@Table(name = "ProductShop")
public class ProductShop {

    @EmbeddedId
    private ProductShopId id;

    @Version
    private int version;

    private String name;
    private Date promotionStartTimestamp;
    private Date promotionEndTimestamp;
    private int pointsPerItem;

    public ProductShopId getId() {
        return id;
    }

    public void setId(ProductShopId id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPromotionStartTimestamp() {
        return promotionStartTimestamp;
    }

    public void setPromotionStartTimestamp(Date promotionStartTimestamp) {
        this.promotionStartTimestamp = promotionStartTimestamp;
    }

    public Date getPromotionEndTimestamp() {
        return promotionEndTimestamp;
    }

    public void setPromotionEndTimestamp(Date promotionEndTimestamp) {
        this.promotionEndTimestamp = promotionEndTimestamp;
    }

    public int getPointsPerItem() {
        return pointsPerItem;
    }

    public void setPointsPerItem(int pointsPerItem) {
        this.pointsPerItem = pointsPerItem;
    }
}
