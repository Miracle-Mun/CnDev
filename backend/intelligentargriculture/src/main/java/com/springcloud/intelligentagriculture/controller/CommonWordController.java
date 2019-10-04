package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.BlacklistService;
import com.springcloud.intelligentagriculture.Service.CommonWordService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.Blacklist;
import com.springcloud.intelligentagriculture.model.CommonWord;
import com.springcloud.intelligentagriculture.model.ProductBusiness;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.BlacklistRepository;
import com.springcloud.intelligentagriculture.repository.CommonWordRepository;
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

@Api(description = "CommonWord API", produces = "application/json", tags = {"监管记录-常用语管理"})

public class CommonWordController {

    @Autowired
    CommonWordRepository commonWordRepository;
    @Autowired
    CommonWordService commonWordService;


    @GetMapping("/common_word/all")
    @ResponseBody
    public ResponseEntity<List<CommonWord>> getAllCommonWords(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "20") Integer pageSize,
                                                                @RequestParam(defaultValue = "id") String sortBy) {

        List<CommonWord> list = commonWordService.getAllWords(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<CommonWord>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @DeleteMapping("/common_word/delete/{id}")
    public ResponseEntity<?> deleteSupervisionRecord(@PathVariable(value = "id") Long id) {
        CommonWord commonWord = commonWordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommonWord", "id", id));

        commonWordRepository.delete(commonWord);

        return ResponseEntity.ok().build();
    }


    @PostMapping("/common_word/create")
    public CommonWord createCommonWord(@Valid @RequestBody CommonWord commonWord) {

        if (!commonWordRepository.existsById(commonWord.getId()))
            return commonWordRepository.save(commonWord);
        else
            return null;
    }


    @PutMapping("/common_word/update/{id}")
    public CommonWord updateCommonWord(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody CommonWord updatedCommonWord) {

        CommonWord commonWord = commonWordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommonWord", "id", id));


        commonWord.setWord(updatedCommonWord.getWord());

        CommonWord updatedistributor = commonWordRepository.save(commonWord);
        return updatedistributor;
    }

}