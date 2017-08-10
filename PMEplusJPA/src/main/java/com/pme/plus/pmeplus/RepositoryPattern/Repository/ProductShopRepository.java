package com.pme.plus.pmeplus.RepositoryPattern.Repository;

import com.pme.plus.pmeplus.Entity.ProductShop;
import com.pme.plus.pmeplus.Entity.UDT.ProductShopId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnkali on 7/29/17.
 */
public interface ProductShopRepository extends CrudRepository<ProductShop, ProductShopId> {
}
