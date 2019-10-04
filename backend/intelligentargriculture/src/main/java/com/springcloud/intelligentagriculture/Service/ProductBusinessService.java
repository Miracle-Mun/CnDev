package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.*;
import com.springcloud.intelligentagriculture.model.ProductBusiness;
import com.springcloud.intelligentagriculture.repository.ProductBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBusinessService
{
    @Autowired
    ProductBusinessRepository repository;

    public List<ProductBusiness> getAllProductBusiness(Integer pageNo, Integer pageSize, String sortBy, int company_id)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ProductBusiness> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, company_id);
        }
        catch (Exception e){
            return new ArrayList<ProductBusiness>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ProductBusiness>();
        }
    }

}