package com.pme.plus.pmeplus.Impl.Service;

import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.RepositoryPattern.Repository.ShopRepository;
import com.pme.plus.pmeplus.api.Service.ShopServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gnkali on 8/6/17.
 */
@Service("shopServiceImpl")
public class ShopServiceImpl implements ShopServiceAPI {

    private ShopRepository shopRepository;

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Iterable<Shop> listAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(Integer id) {
        return shopRepository.findOne(id);
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Integer id) {
        shopRepository.delete(id);
    }
}
