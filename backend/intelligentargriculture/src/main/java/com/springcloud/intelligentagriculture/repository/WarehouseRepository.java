package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.model.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>, PagingAndSortingRepository<Warehouse, Long> {

    @Query(value = "SELECT t.* FROM warehouse AS t WHERE 0 = :company_id or t.company_id = :company_id", nativeQuery = true)
    public Page<Warehouse> findAllBySearch(Pageable pageable, @Param("company_id") int company_id );

}

