package com.springcloud.intelligentagriculture.Service;


import com.springcloud.intelligentagriculture.model.CompanyCreditGrade;
import com.springcloud.intelligentagriculture.repository.CompanyCreditGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyCreditGradeService
{
    @Autowired
    CompanyCreditGradeRepository repository;


    public List<CompanyCreditGrade> getAllCreditGrades(Integer pageNo, Integer pageSize, String sortBy, String approvalStatus, int townId, String creditCode )
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<CompanyCreditGrade> pagedResult = null;
        try{
            //pagedResult = repository.findAllBySearch(paging);
            pagedResult = repository.findAllBySearch(paging, approvalStatus, townId, creditCode);
        }
        catch (Exception e){
            return new ArrayList<CompanyCreditGrade>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CompanyCreditGrade>();
        }
    }
}