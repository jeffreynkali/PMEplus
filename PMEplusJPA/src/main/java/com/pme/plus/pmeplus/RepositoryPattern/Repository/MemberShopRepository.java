package com.pme.plus.pmeplus.RepositoryPattern.Repository;

import com.pme.plus.pmeplus.Entity.MemberShop;
import com.pme.plus.pmeplus.Entity.UDT.MemberShopId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnkali on 7/29/17.
 */
public interface MemberShopRepository extends CrudRepository<MemberShop, MemberShopId> {
}
