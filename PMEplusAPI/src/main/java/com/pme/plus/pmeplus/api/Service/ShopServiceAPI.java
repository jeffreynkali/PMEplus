package com.pme.plus.pmeplus.api.Service;

import com.pme.plus.pmeplus.Entity.Shop;

/**
 * Created by gnkali on 8/6/17.
 */
public interface ShopServiceAPI {

    Iterable<Shop> listAllShops();

    Shop getShopById(Integer id);

    Shop saveShop(Shop shop);

    void deleteShop(Integer id);
}
