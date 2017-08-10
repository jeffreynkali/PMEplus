package com.pme.plus.pmeplus;

/**
 * Created by gnkali on 6/14/17.
 */
import com.pme.plus.pmeplus.DAOPattern.DAO.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //MemberDAO memberDAOImpl = (MemberDAO)context.getBean("memberDAO");
        SpringApplication.run(MainApp.class, args);
    }
}
