package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.WarehouseRepository;
import com.springcloud.intelligentagriculture.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService
{
    @Autowired
    WarehouseRepository repository;

    public List<Warehouse> getAllWarehouses(Integer pageNo, Integer pageSize, String sortBy, int company_id)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Warehouse> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, company_id);
        }
        catch (Exception e){
            return new ArrayList<Warehouse>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Warehouse>();
        }
    }

}