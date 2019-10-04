package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.QualityStandard;
import com.springcloud.intelligentagriculture.repository.QualityStandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualityStandardService
{
    @Autowired
    QualityStandardRepository repository;

    public List<QualityStandard> getAllQualityStandards(Integer pageNo, Integer pageSize, String sortBy, String creditCode, String argriculturalClassification, String cretficationType)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<QualityStandard> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, creditCode, argriculturalClassification, cretficationType );
        }
        catch (Exception e){
            return new ArrayList<QualityStandard>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<QualityStandard>();
        }
    }

}