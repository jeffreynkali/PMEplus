package com.pme.plus.pmeplus.RepositoryPattern.Loader;

import com.pme.plus.pmeplus.Entity.Product;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by gnkali on 7/29/17.
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Product shirt = new Product();
        shirt.setCategory("Clothing");
        shirt.setName("Dressed shirt");
        shirt.setIdProduct(1);
        shirt.setVersion(1);
        productRepository.save(shirt);

        log.info("Saved shirt - id: " + shirt.getIdProduct());

        Product skirt = new Product();
        skirt.setCategory("Clothing");
        skirt.setName("Long skirt");
        skirt.setIdProduct(2);
        skirt.setVersion(1);
        productRepository.save(skirt);

        log.info("Saved skirt - id: " + skirt.getIdProduct());
    }
}
