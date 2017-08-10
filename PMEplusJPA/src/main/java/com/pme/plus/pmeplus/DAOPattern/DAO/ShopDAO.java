package com.pme.plus.pmeplus.DAOPattern.DAO;

import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.Entity.UDT.Address;

import java.util.List;

/**
 * Created by gnkali on 6/20/17.
 */
public interface ShopDAO {

    /**
     * This is the method to be used to createMember
     * a record in the ShopRepository table.
     */
    public void createShop(Address address, String phone, String email);

    /**
     * This is the method to be used to list down
     * a record from the ShopRepository table corresponding
     * to a passed ShopRepository idShop.
     */
    public Shop getShopByID(int idShop);

    /**
     * This is the method to be used to list down
     * all the records from the ShopRepository table.
     */
    public List<Shop> listShops();

    /**
     * This is the method to be used to delete
     * a record from the ShopRepository table corresponding
     * to a passed ShopRepository idShop.
     */
    public void deleteShopByID(int idShop);

    /**
     * This is the method to be used to update
     * a record into the ShopRepository table.
     */
    public void updateShopEmail(int idShop, String email);
}
