package com.pme.plus.pmeplus.DAOPattern.DAO;

import com.pme.plus.pmeplus.Entity.Product;

import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public interface ProductDAO {

    /**
     * This is the method to be used to createProduct
     * a record in the Product table.
     */
    public void createProduct(String name, String category);

    /**
     * This is the method to be used to list down
     * a record from the Product table corresponding
     * to a passed Product idProduct.
     */
    public Product getProductByID(int idProduct);

    /**
     * This is the method to be used to list down
     * all the records from the Product table.
     */
    public List<Product> listProducts();

    /**
     * This is the method to be used to delete
     * a record from the Product table corresponding
     * to a passed Product idProduct.
     */
    public void deleteProductByID(int idProduct);

    /**
     * This is the method to be used to update
     * a record into the Product table.
     */
    public void updateProductName(int idProduct, String name);
}
