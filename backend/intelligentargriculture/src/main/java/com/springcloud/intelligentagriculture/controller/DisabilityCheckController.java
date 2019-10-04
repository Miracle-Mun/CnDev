package com.springcloud.intelligentagriculture.controller;

import com.springcloud.intelligentagriculture.Service.*;
import com.springcloud.intelligentagriculture.exception.ResourceNotFoundException;
import com.springcloud.intelligentagriculture.model.*;
import com.springcloud.intelligentagriculture.repository.*;
import com.springcloud.intelligentagriculture.Service.DisabilityCheckService;
import com.springcloud.intelligentagriculture.repository.DisabilityCheckRepository;
import com.springcloud.intelligentagriculture.model.DisabilityCheck;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@Api(description = "DisabilityCheck API", produces = "application/json", tags = {"农残检测"})

public class DisabilityCheckController {

    @Autowired
    DisabilityCheckRepository disabilityCheckRepository;
    @Autowired
    DisabilityCheckService disabilityCheckService;


    @GetMapping("/disability_check/all")
    @ResponseBody
    public ResponseEntity<List<DisabilityCheck>> getAllDisabilityChecks(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(defaultValue = "20") Integer pageSize,
                                                                        @RequestParam(defaultValue = "id") String sortBy,
                                                                        @RequestParam(defaultValue = "") String creditCode,
                                                                        @RequestParam(defaultValue = "") String item,
                                                                        @RequestParam(defaultValue = "") String sample,
                                                                        @RequestParam(defaultValue = "") String detectUnit,
                                                                        @RequestParam(defaultValue = "") String fromDate,
                                                                        @RequestParam(defaultValue = "") String toDate,
                                                                        @RequestParam(defaultValue = "") String townDivisionCode,
                                                                        @RequestParam(defaultValue = "-1") Integer resultDx

    ) {

        List<DisabilityCheck> list = disabilityCheckService.getAllDisabilityChecks(pageNo, pageSize, sortBy, creditCode, item, sample, detectUnit, fromDate, toDate, townDivisionCode, resultDx );
        return new ResponseEntity<List<DisabilityCheck>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/disability_check/item")
    @ResponseBody
    public ResponseEntity<List<DisabilityCheck>> getAllItems() {

        List<DisabilityCheck> list = disabilityCheckService.getItemAll();
        return new ResponseEntity<List<DisabilityCheck>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/disability_check/sample")
    @ResponseBody
    public ResponseEntity<List<DisabilityCheck>> getAllSamples() {

        List<DisabilityCheck> list = disabilityCheckService.getSampleAll();
        return new ResponseEntity<List<DisabilityCheck>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/disability_check/detect_unit")
    @ResponseBody
    public ResponseEntity<List<DisabilityCheck>> getAllDetectUnit() {

        List<DisabilityCheck> list = disabilityCheckService.getDetectUnitAll();
        return new ResponseEntity<List<DisabilityCheck>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(value="/disability_check/update/{id}", method = RequestMethod.PUT )
    public DisabilityCheck updateDisabilityCheck(@PathVariable(value = "id") Long id, @RequestBody DisabilityCheck updatedDisabilityCheck ) {

        DisabilityCheck disabilityCheck = disabilityCheckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisabilityCheck", "id", id));



        disabilityCheck.setAbs1(updatedDisabilityCheck.getAbs1());
        disabilityCheck.setAbs2(updatedDisabilityCheck.getAbs2());
        disabilityCheck.setChannel(updatedDisabilityCheck.getChannel());
        disabilityCheck.setCreditCode(updatedDisabilityCheck.getCreditCode());
        disabilityCheck.setDelectPlace(updatedDisabilityCheck.getDelectPlace());
        disabilityCheck.setDetectTime(updatedDisabilityCheck.getDetectTime());
        disabilityCheck.setDetectUnit(updatedDisabilityCheck.getDetectUnit());
        disabilityCheck.setDetectUnitId(updatedDisabilityCheck.getDetectUnitId());
        disabilityCheck.setInstrument(updatedDisabilityCheck.getInstrument());
        disabilityCheck.setInstrumentCop(updatedDisabilityCheck.getInstrumentCop());
        disabilityCheck.setItem(updatedDisabilityCheck.getItem());
        disabilityCheck.setItemEn(updatedDisabilityCheck.getItemEn());
        disabilityCheck.setNo(updatedDisabilityCheck.getNo());
        disabilityCheck.setOperator(updatedDisabilityCheck.getOperator());
        disabilityCheck.setReagent(updatedDisabilityCheck.getReagent());

        disabilityCheck.setReagentCop(updatedDisabilityCheck.getReagentCop());
        disabilityCheck.setResultDl(updatedDisabilityCheck.getResultDl());
        disabilityCheck.setResultDx(updatedDisabilityCheck.getResultDx());
        disabilityCheck.setResultDxDesc(updatedDisabilityCheck.getResultDxDesc());
        disabilityCheck.setResultUnit(updatedDisabilityCheck.getResultUnit());
        disabilityCheck.setSample(updatedDisabilityCheck.getSample());
        disabilityCheck.setSampleClass(updatedDisabilityCheck.getSampleClass());
        disabilityCheck.setSource(updatedDisabilityCheck.getSource());
        disabilityCheck.setSourcePic(updatedDisabilityCheck.getSourcePic());
        disabilityCheck.setTownDivisionCode(updatedDisabilityCheck.getTownDivisionCode());
        disabilityCheck.setSpecialFlag(updatedDisabilityCheck.getSpecialFlag());

        DisabilityCheck updatedResult = disabilityCheckRepository.save(updatedDisabilityCheck);
        return updatedResult;
    }

}