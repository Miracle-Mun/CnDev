package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.SampleCheck;
import com.springcloud.intelligentagriculture.model.SampleCheckResult;
import com.springcloud.intelligentagriculture.repository.SampleCheckRepository;
import com.springcloud.intelligentagriculture.repository.SampleCheckResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleCheckResultService
{
    @Autowired
    SampleCheckResultRepository repository;

    public List<SampleCheckResult> getAllSampleCheckResult(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<SampleCheckResult> pagedResult = null;
        try{
            pagedResult = repository.findAll(paging);
        }
        catch (Exception e){
            return new ArrayList<SampleCheckResult>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<SampleCheckResult>();
        }
    }

}