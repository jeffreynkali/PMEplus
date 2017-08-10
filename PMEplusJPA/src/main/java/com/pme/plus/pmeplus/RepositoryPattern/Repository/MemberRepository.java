package com.pme.plus.pmeplus.RepositoryPattern.Repository;

import com.pme.plus.pmeplus.Entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnkali on 7/29/17.
 */
public interface MemberRepository extends CrudRepository<Member, Integer> {
}
