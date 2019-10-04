package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.CompanyCreditGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCreditGradeRepository extends JpaRepository<CompanyCreditGrade, Long>, PagingAndSortingRepository<CompanyCreditGrade, Long> {
   // @Query(value = "SELECT t.* FROM company_credit_grade AS t LEFT JOIN company_production AS q ON t.credit_code = q.credit_code WHERE ( 0 = :townId or q.town_id = :townId ) and ( '-1' = :approval_status or t.approval_status = :approval_status) and ('' = :credit_code or t.credit_code = :credit_code )", nativeQuery = true)



    @Query(value = "SELECT t.* FROM company_credit_grade AS t LEFT JOIN company_production AS q ON t.credit_code = q.credit_code WHERE ( 0 = :townId or q.town_id = :townId ) and ( '-1' = :approval_status or t.approval_status = :approval_status) and ('' = :credit_code or t.credit_code = :credit_code )", nativeQuery = true)
    public Page<CompanyCreditGrade> findAllBySearch(Pageable pageable, @Param("approval_status") String approval_status, @Param("townId") int townId, @Param("credit_code") String credit_code);

    //@Query(value = "SELECT * FROM company_credit_grade AS t", nativeQuery = true)
    //public Page<CompanyCreditGrade> findAllBySearch(Pageable pageable);
}
