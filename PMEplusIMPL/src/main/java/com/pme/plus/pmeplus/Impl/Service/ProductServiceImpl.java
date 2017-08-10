package com.pme.plus.pmeplus.Impl.Service;

import com.pme.plus.pmeplus.Entity.Product;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.ProductRepository;
import com.pme.plus.pmeplus.api.Service.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gnkali on 8/6/17.
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductServiceAPI {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }
}
