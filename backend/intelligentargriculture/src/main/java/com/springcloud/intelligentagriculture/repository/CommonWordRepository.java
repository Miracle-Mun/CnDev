package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.Blacklist;
import com.springcloud.intelligentagriculture.model.CommonWord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonWordRepository extends JpaRepository<CommonWord, Long>, PagingAndSortingRepository<CommonWord, Long> {


}
