package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.CompanyProduction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyProductionRepository extends JpaRepository<CompanyProduction, Long>, PagingAndSortingRepository<CompanyProduction, Long> {


    @Query(value = "SELECT t.* FROM company_production AS t WHERE ( '-1' = :credit_code or t.credit_code = :credit_code ) and ( 0 = :company_id or t.company_id = :company_id)", nativeQuery = true)
    public List<CompanyProduction> findName(@Param("credit_code") String credit_code, @Param("company_id") int company_id);


    @Query(value = "SELECT COUNT(pl.id) AS public_license, COUNT(pp.id) AS public_punish, COUNT(qs.id) AS quality_standard, cp.* FROM company_production AS cp LEFT JOIN public_license AS pl ON cp.credit_code = pl.credit_code LEFT JOIN public_punish AS pp ON cp.credit_code = pp.credit_code LEFT JOIN quality_standard AS qs ON cp.credit_code = qs.credit_code WHERE ( ( 0 = :town_id or cp.town_id = :town_id)) and ( '0' = :company_type or cp.company_type = :company_type ) GROUP BY cp.credit_code", nativeQuery = true)
    public Page<CompanyProduction> findAllCompanyProductions(Pageable pageable, @Param("town_id") int town_id, @Param("company_type") String company_type);
}
