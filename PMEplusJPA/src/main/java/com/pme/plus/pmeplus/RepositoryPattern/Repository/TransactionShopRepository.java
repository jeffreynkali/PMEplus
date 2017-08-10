package com.pme.plus.pmeplus.RepositoryPattern.Repository;

import com.pme.plus.pmeplus.Entity.TransactionShop;
import com.pme.plus.pmeplus.Entity.UDT.TransactionShopId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnkali on 7/29/17.
 */
public interface TransactionShopRepository extends CrudRepository<TransactionShop, TransactionShopId> {
}
