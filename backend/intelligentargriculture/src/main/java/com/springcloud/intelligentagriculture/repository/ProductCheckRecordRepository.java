package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.ProductCheckRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCheckRecordRepository extends JpaRepository<ProductCheckRecord, Long>, PagingAndSortingRepository<ProductCheckRecord, Long> {

    @Query(value = "SELECT t.* FROM product_check_record AS t WHERE 0 = :product_id or t.product_id = :product_id", nativeQuery = true)
    public Page<ProductCheckRecord> findAllBySearch(Pageable pageable, @Param("product_id") int product_id );

}

