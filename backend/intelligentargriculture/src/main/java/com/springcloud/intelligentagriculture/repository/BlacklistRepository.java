package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.Blacklist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long>, PagingAndSortingRepository<Blacklist, Long> {

    @Query(value = "SELECT t.* FROM blacklist AS t LEFT JOIN company_production AS q ON t.credit_code = q.credit_code WHERE ( 0 = :townId or q.town_id = :townId ) and ( 0 = :blacklist_type or t.blacklist_type = :blacklist_type)", nativeQuery = true)
    public Page<Blacklist> findAllBySearch(Pageable pageable, @Param("blacklist_type") int blacklist_type, @Param("townId") int townId);
}
