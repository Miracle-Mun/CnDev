package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.RectificationRecordService;
import com.springcloud.intelligentagriculture.Service.SupervisionRecordService;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.RectificationRecord;
import com.springcloud.intelligentagriculture.model.SupervisionRecord;
import com.springcloud.intelligentagriculture.repository.RectificationRecordRepository;
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

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "RectificationRecord API", produces = "application/json", tags = {"监管记录-整改记录"})

public class RectificationRecordController {

    @Autowired
    RectificationRecordRepository rectificationRecordRepository;
    @Autowired
    RectificationRecordService rectificationRecordService;
    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/rectification_record/all")
    @ResponseBody
    public ResponseEntity<List<RectificationRecord>> getAllRectificationRecords(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(defaultValue = "20") Integer pageSize,
                                                                            @RequestParam(defaultValue = "id") String sortBy,
                                                                            @RequestParam(defaultValue = "0") Integer supervisionRecordId
    ) {

        List<RectificationRecord> list = rectificationRecordService.getAllRectificationRecords(pageNo, pageSize, sortBy, supervisionRecordId);
        return new ResponseEntity<List<RectificationRecord>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value="/rectification_record/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RectificationRecord registerRectificationRecord( @RequestParam("scenePhotoFile") MultipartFile scenePhotoFile, @RequestParam("signFile") MultipartFile signFile, @RequestParam("confirmorSign") MultipartFile confirmorSign, RectificationRecord rectificationRecord ) {


        if( scenePhotoFile != null ){
            String fileName = fileStorageService.storeFile(scenePhotoFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setScenePhotos(fileUploadUri);
        }

        if( signFile != null ){
            String fileName = fileStorageService.storeFile(signFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setSupervisionSign(fileUploadUri);
        }

        if( confirmorSign != null ){
            String fileName = fileStorageService.storeFile(confirmorSign);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setConfirmorSign(fileUploadUri);
        }

        if (!rectificationRecordRepository.existsById(rectificationRecord.getId()))
            return rectificationRecordRepository.save(rectificationRecord);
        else
            return null;
    }





    @RequestMapping(value="/rectification_record/update", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RectificationRecord updateRectificationRecord( @PathVariable(value = "id") Long id, @RequestParam("scenePhotoFile") MultipartFile scenePhotoFile, @RequestParam("signFile") MultipartFile signFile, @RequestParam("confirmorSign") MultipartFile confirmorSign, RectificationRecord updatedRectificationRecord ) {

        RectificationRecord rectificationRecord = rectificationRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RectificationRecord", "id", id));

        if( scenePhotoFile != null ){
            String fileName = fileStorageService.storeFile(scenePhotoFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setScenePhotos(fileUploadUri);
        }

        if( signFile != null ){
            String fileName = fileStorageService.storeFile(signFile);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setSupervisionSign(fileUploadUri);
        }

        if( confirmorSign != null ){
            String fileName = fileStorageService.storeFile(confirmorSign);
            String fileUploadUri = "/uploads/" + fileName.toString();
            rectificationRecord.setConfirmorSign(fileUploadUri);
        }

        rectificationRecord.setCompanyId(updatedRectificationRecord.getCompanyId());
        rectificationRecord.setConclusion(updatedRectificationRecord.getConclusion());
        rectificationRecord.setConclusionFalseInfo(updatedRectificationRecord.getConclusionFalseInfo());
        rectificationRecord.setCreateTime(updatedRectificationRecord.getCreateTime());
        rectificationRecord.setCreateUserId(updatedRectificationRecord.getCreateUserId());
        rectificationRecord.setInspector(updatedRectificationRecord.getInspector());
        rectificationRecord.setRectificationRecordTime(updatedRectificationRecord.getRectificationRecordTime());
        rectificationRecord.setSupervisionRecordId(updatedRectificationRecord.getSupervisionRecordId());
        rectificationRecord.setTownId(updatedRectificationRecord.getTownId());
        rectificationRecord.setUpdateTime(updatedRectificationRecord.getUpdateTime());
        rectificationRecord.setUpdateUserId(updatedRectificationRecord.getUpdateUserId());


        RectificationRecord updatedResult = rectificationRecordRepository.save(rectificationRecord);
        return updatedResult;
    }


}