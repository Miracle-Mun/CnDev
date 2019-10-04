package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.TownService;
import com.springcloud.intelligentagriculture.model.Town;
import com.springcloud.intelligentagriculture.repository.TownRepository;
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

@Api(description = "Town API", produces = "application/json", tags = {"乡镇"})
public class TownController {

    @Autowired
    TownService townService;
    @Autowired
    TownRepository townRepository;

    @GetMapping("/town/all")
    @ResponseBody
    public ResponseEntity<List<Town>> getAllGrades(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "20") Integer pageSize,
                                                                @RequestParam(defaultValue = "id") String sortBy
    ) {

        List<Town> list = townService.getAllTowns(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Town>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/town/create")
    public Town registerGrade(@Valid @RequestBody Town town) {
        if (!townRepository.existsById(town.getId()))
            return townRepository.save(town);
        else
            return null;
    }
}
