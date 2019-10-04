package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.BlacklistService;
import com.springcloud.intelligentagriculture.model.Blacklist;
import com.springcloud.intelligentagriculture.repository.BlacklistRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "Blacklist API", produces = "application/json", tags = {"红黑名单"})

public class BlacklistController {

    @Autowired
    BlacklistRepository blacklistRepository;
    @Autowired
    BlacklistService blacklistService;


    @GetMapping("/blacklist/all")
    @ResponseBody
    public ResponseEntity<List<Blacklist>> getAllBlacklistTypes(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "20") Integer pageSize,
                                                                @RequestParam(defaultValue = "id") String sortBy,
                                                                @RequestParam(defaultValue = "0") Integer blacklistType,
                                                                @RequestParam(defaultValue = "0") Integer townId) {

        List<Blacklist> list = blacklistService.getAllBlacklists(pageNo, pageSize, sortBy, blacklistType, townId);
        return new ResponseEntity<List<Blacklist>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}