package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.ProductProduction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductProductionRepository extends JpaRepository<ProductProduction, Long>, PagingAndSortingRepository<ProductProduction, Long> {

    @Query(value = "SELECT t.* FROM product_production AS t WHERE 0 = :company_id or t.company_id = :company_id", nativeQuery = true)
    public Page<ProductProduction> findAllBySearch(Pageable pageable, @Param("company_id") int company_id );

    @Query(value = "SELECT t.* FROM product_production AS t WHERE 0 = :product_id or t.product_id = :product_id", nativeQuery = true)
    public List<ProductProduction> findName(@Param("product_id") int product_id);
}

