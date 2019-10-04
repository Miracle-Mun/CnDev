package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.CompanyProduction;
import com.springcloud.intelligentagriculture.repository.CompanyProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyProductionService
{
    @Autowired
    CompanyProductionRepository repository;


//    public List<CompanyProduction> getAllCompanyProductions(Integer pageNo, Integer pageSize, String sortBy)
//    {
//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        Page<CompanyProduction> pagedResult = repository.findAll(paging);
//
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<CompanyProduction>();
//        }
//    }

    public List<CompanyProduction> getNameCompanyProductions(String creditCode, Integer companyId)
    {
        List<CompanyProduction> pagedResult = repository.findName(creditCode, companyId);
        return pagedResult;
//        Page<CompanyProduction> pagedResult = repository.findAll(paging);
//
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<CompanyProduction>();
//        }
    }

    public List<CompanyProduction> getAllCompanyProductions(Integer pageNo, Integer pageSize, String sortBy, Integer townId, String companyType )
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<CompanyProduction> pagedResult = repository.findAllCompanyProductions(paging, townId, companyType);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CompanyProduction>();
        }
    }
}