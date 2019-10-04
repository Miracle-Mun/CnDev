package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.*;
import com.springcloud.intelligentagriculture.model.CompanyBusiness;
import com.springcloud.intelligentagriculture.repository.CompanyBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyBusinessService
{
    @Autowired
    CompanyBusinessRepository repository;

    public List<CompanyBusiness> getAllcompanyBusiness(Integer pageNo, Integer pageSize, String sortBy, String product_type, String company_scale)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<CompanyBusiness> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, product_type,company_scale );
        }
        catch (Exception e){
            return new ArrayList<CompanyBusiness>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CompanyBusiness>();
        }
    }

}