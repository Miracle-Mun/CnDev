package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.ProductBusinessService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.ProductBusiness;
import com.springcloud.intelligentagriculture.repository.ProductBusinessRepository;
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

@Api(description = "ProductBusiness API", produces = "application/json", tags = {"经营主体-经营产品"})

public class ProductBusinessController {

    @Autowired
    ProductBusinessRepository productBusinessRepository;
    @Autowired
    ProductBusinessService productBusinessService;


    @GetMapping("/product_business/all")
    @ResponseBody
    public ResponseEntity<List<ProductBusiness>> getAllProductBusiness(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(defaultValue = "20") Integer pageSize,
                                                                  @RequestParam(defaultValue = "id") String sortBy,
                                                                  @RequestParam(defaultValue = "0") Integer company_id
    ) {

        List<ProductBusiness> list = productBusinessService.getAllProductBusiness(pageNo, pageSize, sortBy, company_id);
        return new ResponseEntity<List<ProductBusiness>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @DeleteMapping("/product_business/{id}")
    public ResponseEntity<?> deleteProductBusiness(@PathVariable(value = "id") Long id) {
        ProductBusiness productBusiness = productBusinessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductBusiness", "id", id));

        productBusinessRepository.delete(productBusiness);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/product_business/create")
    public ProductBusiness createProductBusiness(@Valid @RequestBody ProductBusiness productBusiness) {

        if (!productBusinessRepository.existsById(productBusiness.getId()))
            return productBusinessRepository.save(productBusiness);
        else
            return null;
    }
}