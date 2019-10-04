package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.PublicLicense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicLicenseRepository extends JpaRepository<PublicLicense, Long>, PagingAndSortingRepository<PublicLicense, Long> {

    @Query(value = "SELECT t.* FROM public_license AS t WHERE  '' = :credit_code or t.credit_code = :credit_code ", nativeQuery = true)
    public Page<PublicLicense> findAllBySearch(Pageable pageable, @Param("credit_code") String credit_code );
}
