package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.model.ProductBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBusinessRepository extends JpaRepository<ProductBusiness, Long>, PagingAndSortingRepository<ProductBusiness, Long> {

    @Query(value = "SELECT t.* FROM product_business AS t WHERE 0 = :company_id or t.company_id = :company_id", nativeQuery = true)
    public Page<ProductBusiness> findAllBySearch(Pageable pageable, @Param("company_id") int company_id );

}

