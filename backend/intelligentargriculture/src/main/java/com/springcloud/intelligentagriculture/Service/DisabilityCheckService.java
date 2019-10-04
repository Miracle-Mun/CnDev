package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.DisabilityCheckRepository;
import com.springcloud.intelligentagriculture.model.DisabilityCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisabilityCheckService
{
    @Autowired
    DisabilityCheckRepository repository;

    public List<DisabilityCheck> getAllDisabilityChecks(Integer pageNo, Integer pageSize, String sortBy, String creditCode, String item, String sample, String detectUnit, String fromDate, String toDate, String townDivisionCode, Integer resultDx
    )
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<DisabilityCheck> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, creditCode, item, sample, detectUnit, fromDate, toDate, townDivisionCode, resultDx );
        }
        catch (Exception e){
            return new ArrayList<DisabilityCheck>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DisabilityCheck>();
        }
    }


    public List<DisabilityCheck> getItemAll() {
        List<DisabilityCheck> pagedResult = repository.findItem();
        return pagedResult;
    }

    public List<DisabilityCheck> getSampleAll() {
        List<DisabilityCheck> pagedResult = repository.findSample();
        return pagedResult;
    }

    public List<DisabilityCheck> getDetectUnitAll() {
        List<DisabilityCheck> pagedResult = repository.findDetectUnit();
        return pagedResult;
    }
}