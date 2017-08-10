package com.pme.plus.pmeplus.api.Service;

import com.pme.plus.pmeplus.Entity.Product;

/**
 * Created by gnkali on 8/6/17.
 */
public interface ProductServiceAPI {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
