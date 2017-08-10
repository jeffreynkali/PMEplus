package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.Entity.UDT.Address;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.ShopRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by gnkali on 7/29/17.
 */
@Component
public class ShopLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ShopRepository shopRepository;
    private Logger log = Logger.getLogger(ShopLoader.class);

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Shop pme1 = new Shop();
        Address address1 = new Address();
        address1.setStreet("1 Laurier Street");
        address1.setCity("Ottawa");
        address1.setPostalCode("K1K K1K");
        address1.setProvince("ON");
        pme1.setAddress(address1);
        pme1.setRegistrationDate(new Date(Calendar.getInstance().getTimeInMillis()));
        pme1.setPhone("16667778888");
        pme1.setEmail("pme1@pmeplus.com");
        pme1.setIdShop(1);
        pme1.setVersion(1);
        shopRepository.save(pme1);

        log.info("Saved 1st PME - id: " + pme1.getIdShop());

        Shop pme2 = new Shop();
        Address address2 = new Address();
        address2.setStreet("2 Laurier Street");
        address2.setCity("Ottawa");
        address2.setPostalCode("K1K K1K");
        address2.setProvince("ON");
        pme2.setAddress(address2);
        pme2.setRegistrationDate(new Date(Calendar.getInstance().getTimeInMillis()));
        pme2.setPhone("17776668888");
        pme2.setEmail("pme2@pmeplus.com");
        pme2.setIdShop(2);
        pme2.setVersion(1);
        shopRepository.save(pme2);

        log.info("Saved 2nd PME - id: " + pme2.getIdShop());
    }
}
