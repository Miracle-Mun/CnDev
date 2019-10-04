package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.DisabilityCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisabilityCheckRepository extends JpaRepository<DisabilityCheck, Long>, PagingAndSortingRepository<DisabilityCheck, Long> {

    @Query(value = "SELECT t.* FROM disability_check AS t WHERE ('' = :credit_code or t.credit_code = :credit_code) and ('' = :item or t.item = :item) and ('' = :sample or t.sample = :sample) and ('' = :detect_unit or t.detect_unit = :detect_unit) and ('' = :detect_fromtime or t.detect_time >= :detect_fromtime ) and ('' = :detect_totime or t.detect_time <= :detect_totime) and ('' = :town_division_code or t.town_division_code = :town_division_code) and ( -1 = :result_dx or t.result_dx = :result_dx) ", nativeQuery = true)
    public Page<DisabilityCheck> findAllBySearch(Pageable pageable, @Param("credit_code") String credit_code, @Param("item") String item, @Param("sample") String sample, @Param("detect_unit") String detect_unit, @Param("detect_fromtime") String detect_fromtime, @Param("detect_totime") String detect_totime, @Param("town_division_code") String town_division_code , @Param("result_dx") Integer result_dx  );

    @Query(value = "SELECT t.* FROM disability_check AS t GROUP BY t.item", nativeQuery = true)
    public List<DisabilityCheck> findItem();


    @Query(value = "SELECT t.* FROM disability_check AS t GROUP BY t.sample", nativeQuery = true)
    public List<DisabilityCheck> findSample();

    @Query(value = "SELECT t.* FROM disability_check AS t GROUP BY t.detect_unit", nativeQuery = true)
    public List<DisabilityCheck> findDetectUnit();
}
