package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.QualityStandardService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.QualityStandard;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.QualityStandardRepository;
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

@RestController
@RequestMapping("/api")

@Api(description = "QualityStandard API", produces = "application/json", tags = {"三品一标"})

public class QualityStandardController {

    @Autowired
    QualityStandardRepository qualityStandardRepository;
    @Autowired
    QualityStandardService qualityStandardService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/quality_standard/all")
    @ResponseBody
    public ResponseEntity<List<QualityStandard>> getAllQualityStandards(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(defaultValue = "20") Integer pageSize,
                                                                        @RequestParam(defaultValue = "id") String sortBy,
                                                                        @RequestParam(defaultValue = "") String creditCode,
                                                                        @RequestParam(defaultValue = "0") String argriculturalClassification,
                                                                        @RequestParam(defaultValue = "0") String cretficationType  ) {

        List<QualityStandard> list = qualityStandardService.getAllQualityStandards(pageNo, pageSize, sortBy, creditCode, argriculturalClassification, cretficationType);
        return new ResponseEntity<List<QualityStandard>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/quality_standard/create")
    public QualityStandard registerQualityStandard(@Valid @RequestBody QualityStandard qualityStandard) {
        if (!qualityStandardRepository.existsById(qualityStandard.getId()))
            return qualityStandardRepository.save(qualityStandard);
        else
            return null;
    }


    @GetMapping("/quality_standard/get/{id}")
    public QualityStandard getQualityStandardId(@PathVariable(value = "id") Long id) {
        QualityStandard qualityStandard = qualityStandardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QualityStandard", "id", id));
        return qualityStandard;
    }

    @RequestMapping(value="/quality_standard/update/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public QualityStandard updateQualityStandard(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody QualityStandard qualityStandardDetails, MultipartFile file) {

        QualityStandard qualityStandard = qualityStandardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QualityStandard", "id", id));

        if(file != null)
        {
            String fileName = fileStorageService.storeFile(file);
            String fileUploadUri = "/uploads/" + fileName.toString();
            qualityStandard.setFiles(fileUploadUri);
        }


        qualityStandard.setArgriculturalClassification(qualityStandardDetails.getArgriculturalClassification());
        qualityStandard.setCertificationEndTime(qualityStandardDetails.getCertificationEndTime());
        qualityStandard.setCertificationStartTime(qualityStandardDetails.getCertificationStartTime());
        qualityStandard.setCreateDate(qualityStandardDetails.getCreateDate());
        qualityStandard.setCreateTime(qualityStandardDetails.getCreateTime());
        qualityStandard.setCreateUserId(qualityStandardDetails.getCreateUserId());
        qualityStandard.setCreater(qualityStandardDetails.getCreater());
        qualityStandard.setCreditCode(qualityStandardDetails.getCreditCode());
        qualityStandard.setCretficationCategory(qualityStandardDetails.getCretficationCategory());
        qualityStandard.setCretficationType(qualityStandardDetails.getCretficationType());

        qualityStandard.setOutput(qualityStandardDetails.getOutput());
        qualityStandard.setProductId(qualityStandardDetails.getProductId());
        qualityStandard.setUpdateDate(qualityStandardDetails.getUpdateDate());
        qualityStandard.setUpdateTime(qualityStandardDetails.getUpdateTime());
        qualityStandard.setUpdateUserId(qualityStandardDetails.getUpdateUserId());
        qualityStandard.setUpdater(qualityStandardDetails.getUpdater());
        qualityStandard.setCertificationNo(qualityStandardDetails.getCertificationNo());

        QualityStandard updatedistributor = qualityStandardRepository.save(qualityStandard);
        return updatedistributor;
    }


    @DeleteMapping("/quality_standard/delete/{id}")
    public ResponseEntity<?> deleteQualityStandard(@PathVariable(value = "id") Long id) {
        QualityStandard qualityStandard = qualityStandardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QualityStandard", "id", id));

        qualityStandardRepository.delete(qualityStandard);

        return ResponseEntity.ok().build();
    }

}