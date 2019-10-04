package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.model.CompanyBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBusinessRepository extends JpaRepository<CompanyBusiness, Long>, PagingAndSortingRepository<CompanyBusiness, Long> {

    @Query(value = "SELECT t.* FROM company_business AS t WHERE('0' = :product_type or t.product_type = :product_type) and ('0' = :company_scale or t.company_scale = :company_scale)", nativeQuery = true)
    public Page<CompanyBusiness> findAllBySearch(Pageable pageable, @Param("product_type") String product_type, @Param("company_scale") String company_scale );

}

