package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.ProductProductionService;
import com.springcloud.intelligentagriculture.model.ProductProduction;
import com.springcloud.intelligentagriculture.repository.ProductProductionRepository;
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

@Api(description = "ProductProduction API", produces = "application/json", tags = {"产品"})
public class ProductProductionController {

    @Autowired
    ProductProductionService productProductionService;
    @Autowired
    ProductProductionRepository productProductionRepository;

    @GetMapping("/product_production/all")
    @ResponseBody
    public ResponseEntity<List<ProductProduction>> getAllGrades(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "20") Integer pageSize,
                                                                @RequestParam(defaultValue = "product_id") String sortBy,
                                                                @RequestParam(defaultValue = "0") Integer company_id) {

        List<ProductProduction> list = productProductionService.getAllProductions(pageNo, pageSize, sortBy, company_id);
        return new ResponseEntity<List<ProductProduction>>(list, new HttpHeaders(), HttpStatus.OK);
    }



    @GetMapping("/product_production/name")
    @ResponseBody
    public ResponseEntity<List<ProductProduction>> getNames( @RequestParam(defaultValue = "0") Integer productid )  {

        List<ProductProduction> list = productProductionService.getNameProductProductions(productid);
        return new ResponseEntity<List<ProductProduction>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/product_production/create")
    public ProductProduction registerGrade(@Valid @RequestBody ProductProduction productProduction) {
        if (!productProductionRepository.existsById(productProduction.getProductId()))
            return productProductionRepository.save(productProduction);
        else
            return null;
    }
}
