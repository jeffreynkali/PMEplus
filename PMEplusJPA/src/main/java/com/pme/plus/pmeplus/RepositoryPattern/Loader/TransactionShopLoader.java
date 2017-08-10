package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.TransactionShop;
import com.pme.plus.pmeplus.Entity.UDT.TransactionShopId;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.TransactionShopRepository;
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
public class TransactionShopLoader implements ApplicationListener<ContextRefreshedEvent> {

    private TransactionShopRepository transactionShopRepository;
    private Logger log = Logger.getLogger(TransactionShopLoader.class);

    @Autowired
    public void setTransactionShopRepository(TransactionShopRepository transactionShopRepository) {
        this.transactionShopRepository = transactionShopRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TransactionShop manShirtPME1 = new TransactionShop();
        manShirtPME1.setQuantity(1);
        manShirtPME1.setTransactionTimestamp(new Date(Calendar.getInstance().getTimeInMillis()));
        manShirtPME1.setId(new TransactionShopId(1, 1, 1));
        manShirtPME1.setVersion(1);
        transactionShopRepository.save(manShirtPME1);

        log.info("Saved man buying shirt from PME1 - id: " + manShirtPME1.getId());

        TransactionShop womanSkirtPME2 = new TransactionShop();
        womanSkirtPME2.setQuantity(2);
        womanSkirtPME2.setTransactionTimestamp(new Date(Calendar.getInstance().getTimeInMillis()));
        womanSkirtPME2.setId(new TransactionShopId(2, 2, 2));
        womanSkirtPME2.setVersion(1);
        transactionShopRepository.save(womanSkirtPME2);

        log.info("Saved woman buying skirt from PME2 - id: " + womanSkirtPME2.getId());
    }
}
