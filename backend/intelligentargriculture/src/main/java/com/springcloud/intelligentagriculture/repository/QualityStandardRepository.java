package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.QualityStandard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityStandardRepository extends JpaRepository<QualityStandard, Long>, PagingAndSortingRepository<QualityStandard, Long> {

    @Query(value = "SELECT t.* FROM quality_standard AS t WHERE ( '' = :credit_code or t.credit_code = :credit_code ) and ( '0' = :argricultural_classification or t.argricultural_classification = :argricultural_classification) and ( '0' = :cretfication_type or t.cretfication_type = :cretfication_type)", nativeQuery = true)
    public Page<QualityStandard> findAllBySearch(Pageable pageable, @Param("credit_code") String credit_code, @Param("argricultural_classification") String argricultural_classification, @Param("cretfication_type") String cretfication_type);
}
