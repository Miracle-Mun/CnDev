package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.SampleCheckResultService;
import com.springcloud.intelligentagriculture.Service.SampleCheckService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.SampleCheck;
import com.springcloud.intelligentagriculture.model.SampleCheckResult;
import com.springcloud.intelligentagriculture.repository.SampleCheckRepository;
import com.springcloud.intelligentagriculture.repository.SampleCheckResultRepository;
import com.springcloud.intelligentagriculture.utils.FileStorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "SampleCheckResult API", produces = "application/json", tags = {"例行抽样/抽样结果"})

public class SampleCheckResultController {

    @Autowired
    SampleCheckResultRepository sampleCheckResultRepository;
    @Autowired
    SampleCheckResultService sampleCheckResultService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/sample_check_result/all")
    @ResponseBody
    public ResponseEntity<List<SampleCheckResult>> getAllSampleCheckResult(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                           @RequestParam(defaultValue = "20") Integer pageSize,
                                                                           @RequestParam(defaultValue = "id") String sortBy

    ) {

        List<SampleCheckResult> list = sampleCheckResultService.getAllSampleCheckResult(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<SampleCheckResult>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value="/sample_check_result/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleCheckResult createSampleCheckResult(@RequestParam("file") MultipartFile file, SampleCheckResult sampleCheckResult ) {

        if( file != null ){
            String fileName = fileStorageService.storeFile(file);
            String fileUploadUri = "/uploads/" + fileName.toString();
            sampleCheckResult.setCheckFiles(fileUploadUri);
        }

        if (!sampleCheckResultRepository.existsById(sampleCheckResult.getId()))
            return sampleCheckResultRepository.save(sampleCheckResult);
        else
            return null;
    }

    @GetMapping("/sample_check_result/get/{id}")
    public SampleCheckResult getSampleCheckResult(@PathVariable(value = "id") Long id) {

        SampleCheckResult sampleCheckResult = sampleCheckResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SampleCheckResult", "id", id));;

        return sampleCheckResult;
    }
}