package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.ProductRepetoryService;
import com.springcloud.intelligentagriculture.model.ProductRepetory;
import com.springcloud.intelligentagriculture.repository.ProductRepetoryRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "ProductRepertory API", produces = "application/json", tags = {"生产主体-主营产品-库存动态"})

public class ProductRepetoryController {

    @Autowired
    ProductRepetoryRepository productRepetoryRepository;
    @Autowired
    ProductRepetoryService productRepetoryService;


    @GetMapping("/product_repetory/all")
    @ResponseBody
    public ResponseEntity<List<ProductRepetory>> getAllProductRepertorys(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                         @RequestParam(defaultValue = "20") Integer pageSize,
                                                                         @RequestParam(defaultValue = "id") String sortBy,
                                                                         @RequestParam(defaultValue = "0") Integer product_id
    ) {

        List<ProductRepetory> list = productRepetoryService.getAllProductRepetorys(pageNo, pageSize, sortBy, product_id);
        return new ResponseEntity<List<ProductRepetory>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}