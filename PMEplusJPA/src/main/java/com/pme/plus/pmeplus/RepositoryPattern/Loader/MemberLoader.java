package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.Member;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.MemberRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by gnkali on 7/29/17.
 */
@Component
public class MemberLoader implements ApplicationListener<ContextRefreshedEvent> {

    private MemberRepository memberRepository;
    private Logger log = Logger.getLogger(MemberLoader.class);

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Member man = new Member();
        man.setFirstname("John");
        man.setLastname("Doe");
        man.setEmail("jdoe@pmeplus.com");
        man.setIdMember(1);
        man.setVersion(1);
        memberRepository.save(man);

        log.info("Saved Man - id: " + man.getIdMember());

        Member woman = new Member();
        woman.setFirstname("Jane");
        woman.setLastname("Doe");
        woman.setEmail("janedoe@pmeplus.com");
        woman.setIdMember(2);
        woman.setVersion(1);
        memberRepository.save(woman);

        log.info("Saved Woman - id: " + woman.getIdMember());
    }
}
