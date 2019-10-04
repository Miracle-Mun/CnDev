package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.*;
import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.*;
import com.springcloud.intelligentagriculture.Service.PublicPunishService;
import com.springcloud.intelligentagriculture.model.PublicPunish;
import com.springcloud.intelligentagriculture.repository.PublicPunishRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "PublicPunish API", produces = "application/json", tags = {"行政处罚信息"})

public class PublicPunishController {

    @Autowired
    PublicPunishRepository publicPunishRepository;
    @Autowired
    PublicPunishService publicPunishService;


    @GetMapping("/public_punish/all")
    @ResponseBody
    public ResponseEntity<List<PublicPunish>> getAllPublicPunishes(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                                                   @RequestParam(defaultValue = "id") String sortBy,
                                                                   @RequestParam(defaultValue = "") String creditCode
    ) {

        List<PublicPunish> list = publicPunishService.getAllPublicPunishes(pageNo, pageSize, sortBy, creditCode);
        return new ResponseEntity<List<PublicPunish>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}