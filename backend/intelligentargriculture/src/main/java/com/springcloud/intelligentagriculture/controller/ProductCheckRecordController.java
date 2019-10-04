package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.ProductCheckRecordService;
import com.springcloud.intelligentagriculture.model.ProductCheckRecord;
import com.springcloud.intelligentagriculture.repository.ProductCheckRecordRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "ProductCheckRecord API", produces = "application/json", tags = {"生产主体-主营产品-第三方抽检"})

public class ProductCheckRecordController {

    @Autowired
    ProductCheckRecordRepository productCheckRecordRepository;
    @Autowired
    ProductCheckRecordService productCheckRecordService;


    @GetMapping("/product_check_record/all")
    @ResponseBody
    public ResponseEntity<List<ProductCheckRecord>> getAllGrades(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                 @RequestParam(defaultValue = "20") Integer pageSize,
                                                                 @RequestParam(defaultValue = "id") String sortBy,
                                                                 @RequestParam(defaultValue = "0") Integer product_id
    ) {

        List<ProductCheckRecord> list = productCheckRecordService.getAllProductCheckRecords(pageNo, pageSize, sortBy, product_id);
        return new ResponseEntity<List<ProductCheckRecord>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}