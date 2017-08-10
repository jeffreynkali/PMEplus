package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.MemberShop;
import com.pme.plus.pmeplus.Entity.UDT.MemberShopId;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.MemberShopRepository;
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
public class MemberShopLoader implements ApplicationListener<ContextRefreshedEvent> {

    private MemberShopRepository memberShopRepository;
    private Logger log = Logger.getLogger(MemberShopLoader.class);

    @Autowired
    public void setMemberShopRepository(MemberShopRepository memberShopRepository) {
        this.memberShopRepository = memberShopRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        MemberShop manPME1 = new MemberShop();
        manPME1.setCardNumber("000011110000");
        manPME1.setPoints(100);
        manPME1.setRegistrationDate(new Date(Calendar.getInstance().getTimeInMillis()));
        manPME1.setId(new MemberShopId(1,1));
        manPME1.setVersion(1);
        memberShopRepository.save(manPME1);

        log.info("Saved Man as customer of PME1 - id: " + manPME1.getId());

        MemberShop womanPME2 = new MemberShop();
        womanPME2.setCardNumber("111100001111");
        womanPME2.setPoints(150);
        womanPME2.setRegistrationDate(new Date(Calendar.getInstance().getTimeInMillis()));
        womanPME2.setId(new MemberShopId(2,2));
        womanPME2.setVersion(1);
        memberShopRepository.save(womanPME2);

        log.info("Saved Woman as customer of PME2 - id: " + womanPME2.getId());
    }
}
