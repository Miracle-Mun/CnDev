package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.ProductCheckRecord;
import com.springcloud.intelligentagriculture.repository.ProductCheckRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCheckRecordService
{
    @Autowired
    ProductCheckRecordRepository repository;

    public List<ProductCheckRecord> getAllProductCheckRecords(Integer pageNo, Integer pageSize, String sortBy, int product_id)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ProductCheckRecord> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, product_id);
        }
        catch (Exception e){
            return new ArrayList<ProductCheckRecord>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ProductCheckRecord>();
        }
    }

}