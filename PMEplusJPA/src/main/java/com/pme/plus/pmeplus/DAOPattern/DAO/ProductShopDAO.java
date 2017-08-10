package com.pme.plus.pmeplus.DAOPattern.DAO;

import com.pme.plus.pmeplus.Entity.ProductShop;

import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public interface ProductShopDAO {

    /**
     * This is the method to be used to create
     * a record in the ProductShop table.
     */
    public void createProductShop(ProductShop productShop);

    /**
     * This is the method to be used to list down
     * a record from the ProductShop table corresponding
     * to a passed ProductShop (idProduct, idShop).
     */
    public ProductShop getProductShopByIDs(int idProduct, int idShop);

    /**
     * This is the method to be used to list down
     * all the records from the ProductShop table.
     */
    public List<ProductShop> listProductShops();

    /**
     * This is the method to be used to delete
     * a record from the ProductShop table corresponding
     * to a passed ProductShop (idProduct, idShop).
     */
    public void deleteProductShopByIDs(int idProduct, int idShop);

    /**
     * This is the method to be used to update the name
     * a record into the ProductShop table.
     */
    public void updateProductShopName(int idProduct, int idShop, String name);

    /**
     * This is the method to be used to update the pointsPerItem
     * a record into the ProductShop table.
     */
    public void updateProductShopPointsPerItem(int idProduct, int idShop, int pointsPerItem);
}
