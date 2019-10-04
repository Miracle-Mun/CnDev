package com.springcloud.intelligentagriculture.controller;


import com.springcloud.intelligentagriculture.Service.SampleCheckService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.SampleCheck;
import com.springcloud.intelligentagriculture.model.SampleCheckResult;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.SampleCheckRepository;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "SampleCheck API", produces = "application/json", tags = {"例行抽样/抽样计划"})

public class SampleCheckController {

    @Autowired
    SampleCheckRepository sampleCheckRepository;
    @Autowired
    SampleCheckService sampleCheckService;

    @Autowired
    private FileStorageService fileStorageService;


    @GetMapping("/sample_check/all")
    @ResponseBody
    public ResponseEntity<List<SampleCheck>> getAllSampleCheck(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "20") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String sortBy

    ) {

        List<SampleCheck> list = sampleCheckService.getAllSampleCheck(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<SampleCheck>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/sample_check/get/{id}")
    public SampleCheck getSampleCheck(@PathVariable(value = "id") Long id) {

        SampleCheck sampleCheck = sampleCheckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SampleCheck", "id", id));;

        return sampleCheck;
    }

    @RequestMapping(value="/sample_check/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleCheck createSampleCheck(@RequestParam("file") MultipartFile file,  SampleCheck sampleCheck ) {


        if( file != null ){
            String fileName = fileStorageService.storeFile(file);
            String fileUploadUri = "/uploads/" + fileName.toString();
            sampleCheck.setCheckFiles(fileUploadUri);
        }

        if (!sampleCheckRepository.existsById(sampleCheck.getId()))
            return sampleCheckRepository.save(sampleCheck);
        else
            return null;
    }

    @RequestMapping(value="/sample_check/update/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleCheck updateSampleCheck(MultipartFile file, @PathVariable(value = "id") Long id, SampleCheck sampleCheckDetails )
    {

        SampleCheck sampleCheck = sampleCheckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SampleCheck", "id", id));

        if( file != null ){
            String fileName = fileStorageService.storeFile(file);
            String fileUploadUri = "/uploads/" + fileName.toString();
            sampleCheck.setCheckFiles(fileUploadUri);
        }

        sampleCheck.setSampleId(sampleCheckDetails.getSampleId());
        sampleCheck.setSampleName(sampleCheckDetails.getSampleName());
        sampleCheck.setSampleTime(sampleCheckDetails.getSampleTime());
        sampleCheck.setCheckPerson(sampleCheckDetails.getCheckPerson());
        sampleCheck.setCreateTime(sampleCheckDetails.getCreateTime());
        sampleCheck.setCreateUserId(sampleCheckDetails.getCreateUserId());
        sampleCheck.setUpdateTime(sampleCheckDetails.getUpdateTime());
        sampleCheck.setUpdateUserId(sampleCheckDetails.getUpdateUserId());

        SampleCheck updatedistributor = sampleCheckRepository.save(sampleCheck);
        return updatedistributor;
    }



}