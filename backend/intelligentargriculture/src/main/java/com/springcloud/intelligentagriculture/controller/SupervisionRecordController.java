package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.SupervisionRecordService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.SampleCheckResult;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.SupervisionRecordRepository;
import com.springcloud.intelligentagriculture.utils.FileStorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "SupervisionRecord API", produces = "application/json", tags = {"监管记录"})

public class SupervisionRecordController {

    @Autowired
    SupervisionRecordRepository supervisionRecordRepository;
    @Autowired
    SupervisionRecordService supervisionRecordService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/supervision_record/all")
    @ResponseBody
    public ResponseEntity<List<SupervisionRecord>> getAllSupervisionRecords(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(defaultValue = "20") Integer pageSize,
                                                                            @RequestParam(defaultValue = "id") String sortBy,
                                                                            @RequestParam(defaultValue = "0") Integer companyId
                                                                ) {

        List<SupervisionRecord> list = supervisionRecordService.getAllSupervisionRecords(pageNo, pageSize, sortBy, companyId);
        return new ResponseEntity<List<SupervisionRecord>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value="/supervision_record/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupervisionRecord registerSupervisionRecord( @RequestParam("file1") MultipartFile scenePhotoFile, @RequestParam("file2") MultipartFile signFile, SupervisionRecord supervisionRecord ) {


        if( scenePhotoFile != null ){
            String fileName = fileStorageService.storeFile(scenePhotoFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            supervisionRecord.setScenePhotos(fileUploadUri);
        }

        if( signFile != null ){
            String fileName = fileStorageService.storeFile(signFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            supervisionRecord.setSign(fileUploadUri);
        }

        if (!supervisionRecordRepository.existsById(supervisionRecord.getId()))
            return supervisionRecordRepository.save(supervisionRecord);
        else
            return null;
    }


    @DeleteMapping("/supervision_record/delete/{id}")
    public ResponseEntity<?> deleteSupervisionRecord(@PathVariable(value = "id") Long id) {
        SupervisionRecord supervisionRecord = supervisionRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupervisionRecord", "id", id));

        supervisionRecordRepository.delete(supervisionRecord);

        return ResponseEntity.ok().build();
    }


    @RequestMapping(value="/supervision_record/update/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupervisionRecord updateSupervisionRecord(MultipartFile file1, MultipartFile file2, @PathVariable(value = "id") Long id, String conclusionFalseInfo, String conclusion, String inspector,
                                                     Long companyId, Long townId, Date createTime )
     {

        SupervisionRecord supervisionRecord = supervisionRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupervisionRecord", "id", id));

        if( file1 != null ){
            String fileName = fileStorageService.storeFile(file1);
            String fileUploadUri = "/uploads/" + fileName.toString();
            supervisionRecord.setScenePhotos(fileUploadUri);
        }

        if( file2 != null ){
            String fileName = fileStorageService.storeFile(file2);
            String fileUploadUri = "/uploads/" + fileName.toString();
            supervisionRecord.setSign(fileUploadUri);
        }
         supervisionRecord.setTownId(townId);
         supervisionRecord.setCompanyId(companyId);
         supervisionRecord.setInspector(inspector);
         supervisionRecord.setConclusion(conclusion);
         supervisionRecord.setConclusionFalseInfo(conclusionFalseInfo);
         supervisionRecord.setCreateTime(createTime);

//        supervisionRecord.setProductionSubjectType(updatedSupervisionRecord.getProductionSubjectType());
//
//        supervisionRecord.setSupervisionRecordTime(updatedSupervisionRecord.getSupervisionRecordTime());
//
//        supervisionRecord.setUsefulExpressions(updatedSupervisionRecord.getUsefulExpressions());
//
//        supervisionRecord.setOtherProblems(updatedSupervisionRecord.getOtherProblems());
//
//
//        supervisionRecord.setSupervisionInfo(updatedSupervisionRecord.getSupervisionInfo());
//
//        supervisionRecord.setCreateUserId(updatedSupervisionRecord.getCreateUserId());
//        supervisionRecord.setUsefulExpressions(updatedSupervisionRecord.getUsefulExpressions());
//        supervisionRecord.setUpdateTime(updatedSupervisionRecord.getUpdateTime());
//        supervisionRecord.setUpdateUserId(updatedSupervisionRecord.getUpdateUserId());
//        supervisionRecord.setSpecialFlag(updatedSupervisionRecord.getSpecialFlag());

        SupervisionRecord updatedResult = supervisionRecordRepository.save(supervisionRecord);
        return updatedResult;
    }


    @GetMapping("/supervision_record/get/{id}")
    public SupervisionRecord getSupervisionRecord(@PathVariable(value = "id") Long id) {

        SupervisionRecord supervisionRecord = supervisionRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupervisionRecord", "id", id));;

        return supervisionRecord;
    }
}