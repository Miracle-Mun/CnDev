package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.RectificationRecord;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.RectificationRecordRepository;
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
public class RectificationRecordService
{
    @Autowired
    RectificationRecordRepository repository;

    public List<RectificationRecord> getAllRectificationRecords(Integer pageNo, Integer pageSize, String sortBy, Integer supervisionRecordId)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<RectificationRecord> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, supervisionRecordId);
        }
        catch (Exception e){
            return new ArrayList<RectificationRecord>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<RectificationRecord>();
        }
    }

}