package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.CompanyProductionService;
import com.springcloud.intelligentagriculture.model.CompanyProduction;
import com.springcloud.intelligentagriculture.repository.CompanyProductionRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "CompanyProduction API", produces = "application/json", tags = {"生产主体"})
public class CompanyProductionController {

    @Autowired
    CompanyProductionService companyProductionService;
    @Autowired
    CompanyProductionRepository companyProductionRepository;

//    @GetMapping("/company_production/all")
//    @ResponseBody
//    public ResponseEntity<List<CompanyProduction>> getAllGrades(@RequestParam(defaultValue = "0") Integer pageNo,
//                                                                @RequestParam(defaultValue = "20") Integer pageSize,
//                                                                @RequestParam(defaultValue = "company_id") String sortBy
//                                                                ) {
//
//        List<CompanyProduction> list = companyProductionService.getAllCompanyProductions(pageNo, pageSize, sortBy);
//        return new ResponseEntity<List<CompanyProduction>>(list, new HttpHeaders(), HttpStatus.OK);
//    }

    @GetMapping("/company_production/name")
    @ResponseBody
    public ResponseEntity<List<CompanyProduction>> getNames(    @RequestParam(defaultValue = "-1") String creditCode,
                                                                @RequestParam(defaultValue = "0") Integer companyid )  {

        List<CompanyProduction> list = companyProductionService.getNameCompanyProductions(creditCode, companyid);
        return new ResponseEntity<List<CompanyProduction>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/company_production/create")
    public CompanyProduction registerGrade(@Valid @RequestBody CompanyProduction companyProduction) {
        if (!companyProductionRepository.existsById(companyProduction.getCompanyId()))
            return companyProductionRepository.save(companyProduction);
        else
            return null;
    }

    @GetMapping("/company_production/all")
    @ResponseBody
    public ResponseEntity<List<CompanyProduction>> CompanyProduction(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(defaultValue = "20") Integer pageSize,
                                                                            @RequestParam(defaultValue = "company_id") String sortBy,
                                                                             @RequestParam(defaultValue = "0") Integer townId,
                                                                             @RequestParam(defaultValue = "0") String companyType

    ) {

        List<CompanyProduction> list = companyProductionService.getAllCompanyProductions(pageNo, pageSize, sortBy, townId, companyType);
        return new ResponseEntity<List<CompanyProduction>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
