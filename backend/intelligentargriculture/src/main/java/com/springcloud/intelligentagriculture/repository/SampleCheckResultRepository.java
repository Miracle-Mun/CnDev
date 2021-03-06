package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.SampleCheck;
import com.springcloud.intelligentagriculture.model.SampleCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleCheckResultRepository extends JpaRepository<SampleCheckResult, Long>, PagingAndSortingRepository<SampleCheckResult, Long> {

    //   @Query(value = "SELECT t.* FROM supervision_record AS t WHERE 0 = :company_id or t.company_id = :company_id", nativeQuery = true)
//    public Page<SupervisionRecord> findAllBySearch(Pageable pageable, @Param("company_id") Integer company_id);
}
