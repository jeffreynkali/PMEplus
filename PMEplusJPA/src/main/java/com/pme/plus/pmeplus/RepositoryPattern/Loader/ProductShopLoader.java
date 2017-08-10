package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.ProductShop;
import com.pme.plus.pmeplus.Entity.UDT.ProductShopId;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.ProductShopRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by gnkali on 7/29/17.
 */
@Component
public class ProductShopLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductShopRepository productShopRepository;
    private Logger log = Logger.getLogger(ProductShopLoader.class);

    @Autowired
    public void setProductShopRepository(ProductShopRepository productShopRepository) {
        this.productShopRepository = productShopRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        Date start = new Date();
        Date end = new Date();
        try {
            start = formatter.parse("1-Sep-2017,08:00:00 PM");
            end = formatter.parse("30-Sep-2017,21:00:00 PM");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ProductShop shirtPME1 = new ProductShop();
        shirtPME1.setPointsPerItem(7);
        shirtPME1.setName("Dressed shirt PME1");
        shirtPME1.setPromotionStartTimestamp(new java.sql.Date(start.getTime()));
        shirtPME1.setPromotionEndTimestamp(new java.sql.Date(end.getTime()));
        shirtPME1.setId(new ProductShopId(1, 1));
        shirtPME1.setVersion(1);
        productShopRepository.save(shirtPME1);

        log.info("Saved shirt for PME1 - id: " + shirtPME1.getId());

        ProductShop skirtPME2 = new ProductShop();
        skirtPME2.setPointsPerItem(5);
        skirtPME2.setName("Long skirt PME2");
        skirtPME2.setPromotionStartTimestamp(new java.sql.Date(start.getTime()));
        skirtPME2.setPromotionEndTimestamp(new java.sql.Date(end.getTime()));
        skirtPME2.setId(new ProductShopId(2, 2));
        skirtPME2.setVersion(1);
        productShopRepository.save(skirtPME2);

        log.info("Saved skirt for PME2 - id: " + skirtPME2.getId());
    }
}
