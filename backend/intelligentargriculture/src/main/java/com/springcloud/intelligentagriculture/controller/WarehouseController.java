package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.WarehouseService;
import com.springcloud.intelligentagriculture.model.Warehouse;
import com.springcloud.intelligentagriculture.repository.WarehouseRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "Warehouse API", produces = "application/json", tags = {"生产主体-仓储环境"})

public class WarehouseController {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseService warehouseService;


    @GetMapping("/warehose/all")
    @ResponseBody
    public ResponseEntity<List<Warehouse>> getAllWarehouses(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "20") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String sortBy,
                                                            @RequestParam(defaultValue = "0") Integer company_id
    ) {

        List<Warehouse> list = warehouseService.getAllWarehouses(pageNo, pageSize, sortBy, company_id);
        return new ResponseEntity<List<Warehouse>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}