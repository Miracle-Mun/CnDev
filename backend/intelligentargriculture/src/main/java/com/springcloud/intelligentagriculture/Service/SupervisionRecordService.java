package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.SupervisionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupervisionRecordService
{
    @Autowired
    SupervisionRecordRepository repository;

    public List<SupervisionRecord> getAllSupervisionRecords(Integer pageNo, Integer pageSize, String sortBy, Integer companyId)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<SupervisionRecord> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, companyId);
        }
        catch (Exception e){
            return new ArrayList<SupervisionRecord>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<SupervisionRecord>();
        }
    }

}