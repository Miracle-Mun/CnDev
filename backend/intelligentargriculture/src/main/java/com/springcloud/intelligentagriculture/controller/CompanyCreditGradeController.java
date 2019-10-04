package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.CompanyCreditGradeService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.CompanyCreditGrade;
import com.springcloud.intelligentagriculture.repository.CompanyCreditGradeRepository;
import com.springcloud.intelligentagriculture.utils.FileStorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

//import org.json.JSONObject;

@RestController
@RequestMapping("/api")

@Api(description = "CompanyCreditGrade API", produces = "application/json", tags = {"信用评级"})

public class CompanyCreditGradeController {

    @Autowired
    CompanyCreditGradeRepository creditGradeRepository;
    @Autowired
    CompanyCreditGradeService creditGradeService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/company_credit_grade/all")
    @ResponseBody
    public ResponseEntity<List<CompanyCreditGrade>> getAllGrades(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                 @RequestParam(defaultValue = "20") Integer pageSize,
                                                                 @RequestParam(defaultValue = "credit_grade_id") String sortBy,
                                                                 @RequestParam(defaultValue = "-1") String approvalStatus,
                                                                 @RequestParam(defaultValue = "0") Integer townId,
                                                                 @RequestParam(defaultValue = "") String creditCode) {

        List<CompanyCreditGrade> list = creditGradeService.getAllCreditGrades(pageNo, pageSize, sortBy, approvalStatus, townId, creditCode);
        return new ResponseEntity<List<CompanyCreditGrade>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/company_credit_grade/create")
    public CompanyCreditGrade registerGrade(@Valid @RequestBody CompanyCreditGrade companyCreditGrade) {
        if (!creditGradeRepository.existsById(companyCreditGrade.getCreditGradeId()))
            return creditGradeRepository.save(companyCreditGrade);
        else
            return null;
    }


    @GetMapping("/company_credit_grade/get/{id}")
    public CompanyCreditGrade getGradeId(@PathVariable(value = "id") Long id) {
        CompanyCreditGrade creditGrade = creditGradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompanyCreditGrade", "id", id));
        return creditGrade;
    }


    @RequestMapping(value="/company_credit_grade/update/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public CompanyCreditGrade updateGrade(MultipartFile file, @PathVariable(value = "id") Long id, String updatedNowGrade ) {

        CompanyCreditGrade updatedGrade = creditGradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompanyCreditGrade", "id", id));

        if( file != null ){
            String fileName = fileStorageService.storeFile(file);
            String fileUploadUri = "/uploads/" + fileName.toString();
            updatedGrade.setUploadFileName(fileUploadUri);
        }

        if(updatedNowGrade != null )
            updatedGrade.setNowGrade(updatedNowGrade);

        CompanyCreditGrade updatedistributor = creditGradeRepository.save(updatedGrade);
        return updatedistributor;
    }

}
