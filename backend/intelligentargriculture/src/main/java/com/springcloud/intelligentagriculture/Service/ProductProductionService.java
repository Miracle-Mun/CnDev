package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.ProductProduction;
import com.springcloud.intelligentagriculture.repository.ProductProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductProductionService
{
    @Autowired
    ProductProductionRepository repository;


    public List<ProductProduction> getAllProductions(Integer pageNo, Integer pageSize, String sortBy, int company_id)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ProductProduction> pagedResult = repository.findAllBySearch(paging, company_id);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ProductProduction>();
        }
    }

    public List<ProductProduction> getNameProductProductions(Integer productId)
    {
        List<ProductProduction> pagedResult = repository.findName(productId);
        return pagedResult;
    }
}