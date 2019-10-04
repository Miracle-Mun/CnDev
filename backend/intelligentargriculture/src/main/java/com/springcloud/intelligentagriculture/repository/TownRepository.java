package com.springcloud.intelligentagriculture.repository;

import com.springcloud.intelligentagriculture.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long>, PagingAndSortingRepository<Town, Long> {


}
