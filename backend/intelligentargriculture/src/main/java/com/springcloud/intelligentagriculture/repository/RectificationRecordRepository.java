package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.ProductProduction;
import com.springcloud.intelligentagriculture.model.QualityStandard;
import com.springcloud.intelligentagriculture.model.RectificationRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RectificationRecordRepository extends JpaRepository<RectificationRecord, Long>, PagingAndSortingRepository<RectificationRecord, Long> {

    @Query(value = "SELECT t.* FROM rectification_record AS t WHERE 0 = :supervision_record_id or t.supervision_record_id = :supervision_record_id", nativeQuery = true)
    public Page<RectificationRecord> findAllBySearch(Pageable pageable, @Param("supervision_record_id") int supervision_record_id );
}
