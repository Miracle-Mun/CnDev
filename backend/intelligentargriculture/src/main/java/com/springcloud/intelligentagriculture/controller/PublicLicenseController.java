package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.PublicLicenseService;
import com.springcloud.intelligentagriculture.model.PublicLicense;
import com.springcloud.intelligentagriculture.repository.PublicLicenseRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "PublicLicense API", produces = "application/json", tags = {"行政许可信息"})

public class PublicLicenseController {

    @Autowired
    PublicLicenseRepository publicLicenseRepository;
    @Autowired
    PublicLicenseService publicLicenseService;


    @GetMapping("/public_license/all")
    @ResponseBody
    public ResponseEntity<List<PublicLicense>> getAllQualityStandards(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(defaultValue = "20") Integer pageSize,
                                                                      @RequestParam(defaultValue = "id") String sortBy,
                                                                      @RequestParam(defaultValue = "") String creditCode
                                                                      ) {

        List<PublicLicense> list = publicLicenseService.getAllPublicLicenses(pageNo, pageSize, sortBy, creditCode);
        return new ResponseEntity<List<PublicLicense>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}