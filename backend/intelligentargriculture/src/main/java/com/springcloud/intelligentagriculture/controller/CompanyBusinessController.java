package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.CompanyBusinessService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.CompanyBusiness;
import com.springcloud.intelligentagriculture.repository.CompanyBusinessRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "CompanyBusiness API", produces = "application/json", tags = {"经营主体"})

public class CompanyBusinessController {

    @Autowired
    CompanyBusinessRepository companyBusinessRepository;
    @Autowired
    CompanyBusinessService companyBusinessService;


    @GetMapping("/company_business/all")
    @ResponseBody
    public ResponseEntity<List<CompanyBusiness>> getAllcompanyBusiness(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                       @RequestParam(defaultValue = "20") Integer pageSize,
                                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                                       @RequestParam(defaultValue = "0") String product_type,
                                                                       @RequestParam(defaultValue = "0") String company_scale
    ) {

        List<CompanyBusiness> list = companyBusinessService.getAllcompanyBusiness(pageNo, pageSize, sortBy, product_type, company_scale);
        return new ResponseEntity<List<CompanyBusiness>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/company_business/get/{id}")
    public CompanyBusiness getcompanyBusiness(@PathVariable(value = "id") Long id) {

        CompanyBusiness companyBusiness = companyBusinessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompanyBusiness", "id", id));

        return companyBusiness;
    }


}