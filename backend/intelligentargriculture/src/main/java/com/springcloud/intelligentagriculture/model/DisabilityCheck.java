package com.springcloud.intelligentagriculture.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "disability_check")
@EntityListeners(AuditingEntityListener.class)


public class DisabilityCheck implements Serializable {
    @ApiModelProperty(value = "农残检测ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "编号")
    @NotNull
    @Length(max = 32, message = "*No must have at max 32 characters")
    private String no;

    @ApiModelProperty(value = "通道，孔位")
    @NotNull
    @Length(max = 18, message = "*Channel must have at max 18 characters")
    private String channel;

    @ApiModelProperty(value = "行政相对人代码_1 (统一社会信用代码)")
    @NotNull
    @Length(max = 64, message = "*CreditCode must have at max 64 characters")
    private String creditCode;

    @ApiModelProperty(value = "检测项目名称")
    @NotNull
    @Length(max = 64, message = "*Item must have at max 64 characters for utf8")
    private String item;

    @ApiModelProperty(value = "检测项目项目英文名")
    @NotNull
    @Length(max = 64, message = "*ItemEn must have at max 64 characters")
    private String itemEn;

    @ApiModelProperty(value = "样品名称")
    @NotNull
    @Length(max = 64, message = "*Sample must have at max 64 characters for utf8")
    private String sample;

    @ApiModelProperty(value = "样品类型")
    @NotNull
    @Length(max = 64, message = "*SampleClass must have at max 64 characters for utf8")
    private String sampleClass;

    @ApiModelProperty(value = "来源单位")
    @NotNull
    @Length(max = 64, message = "*Source must have at max 64 characters for utf8")
    private String source;

    @ApiModelProperty(value = "来源单位负责人")
    @NotNull
    @Length(max = 64, message = "*SourcePic must have at max 64 characters for utf8")
    private String sourcePic;

    @ApiModelProperty(value = "第一次吸光度")
    @NotNull
    private Float abs1;

    @ApiModelProperty(value = "第二次吸光度")
    @NotNull
    private Float abs2;

    @ApiModelProperty(value = "定量结果")
    @NotNull
    private Float resultDl;

    @ApiModelProperty(value = "定性结果 *  1合格 0不合格 2疑似")
    @NotNull
    private Long resultDx;

    @ApiModelProperty(value = "定性结果的中文表述")
    @NotNull
    @Length(max = 64, message = "*ResultDxDesc must have at max 64 characters for utf8")
    private String resultDxDesc;

    @ApiModelProperty(value = "单位")
    @NotNull
    @Length(max = 8, message = "*ResultUnit must have at max 8 characters for utf8")
    private String resultUnit;

    @ApiModelProperty(value = "检测地点")
    @NotNull
    @Length(max = 256, message = "*DelectPlace must have at max 256 characters for utf8")
    private String delectPlace;

    @ApiModelProperty(value = "检测时间 (YYYY-MM-DD HH:MM:SS")
    @NotNull
    private Date detectTime;

    @ApiModelProperty(value = "检测单位")
    @NotNull
    @Length(max = 128, message = "*DetectUnit must have at max 128 characters for utf8")
    private String detectUnit;

    @ApiModelProperty(value = "检测员")
    @NotNull
    @Length(max = 32, message = "*Operator must have at max 32 characters for utf8")
    private String operator;

    @ApiModelProperty(value = "试剂")
    @NotNull
    @Length(max = 128, message = "*Reagent must have at max 128 characters for utf8")
    private String reagent;

    @ApiModelProperty(value = "试剂公司")
    @NotNull
    @Length(max = 128, message = "*ReagentCop must have at max 128 characters for utf8")
    private String reagentCop;

    @ApiModelProperty(value = "仪器")
    @NotNull
    @Length(max = 64, message = "*instrument must have at max 64 characters for utf8")
    private String instrument;

    @ApiModelProperty(value = "仪器公司")
    @NotNull
    @Length(max = 128, message = "*instrumentCop must have at max 128 characters for utf8")
    private String instrumentCop;

    public String getTownDivisionCode() {
        return townDivisionCode;
    }

    public void setTownDivisionCode(String townDivisionCode) {
        this.townDivisionCode = townDivisionCode;
    }

    public Long getSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(Long specialFlag) {
        this.specialFlag = specialFlag;
    }

    @ApiModelProperty(value = "检测单位编号")
    @NotNull
    @Length(max = 32, message = "*DetectUnitId must have at max 32 characters")
    private String detectUnitId;


    @ApiModelProperty(value = "乡镇")
    @Length(max = 32, message = "*townDivisionCode must have at max 32 characters")
    private String townDivisionCode;


    @ApiModelProperty(value = "专项")
    private Long specialFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemEn() {
        return itemEn;
    }

    public void setItemEn(String itemEn) {
        this.itemEn = itemEn;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(String sampleClass) {
        this.sampleClass = sampleClass;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourcePic() {
        return sourcePic;
    }

    public void setSourcePic(String sourcePic) {
        this.sourcePic = sourcePic;
    }

    public Float getAbs1() {
        return abs1;
    }

    public void setAbs1(Float abs1) {
        this.abs1 = abs1;
    }

    public Float getAbs2() {
        return abs2;
    }

    public void setAbs2(Float abs2) {
        this.abs2 = abs2;
    }

    public Float getResultDl() {
        return resultDl;
    }

    public void setResultDl(Float resultDl) {
        this.resultDl = resultDl;
    }

    public Long getResultDx() {
        return resultDx;
    }

    public void setResultDx(Long resultDx) {
        this.resultDx = resultDx;
    }

    public String getResultDxDesc() {
        return resultDxDesc;
    }

    public void setResultDxDesc(String resultDxDesc) {
        this.resultDxDesc = resultDxDesc;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    public void setResultUnit(String resultUnit) {
        this.resultUnit = resultUnit;
    }

    public String getDelectPlace() {
        return delectPlace;
    }

    public void setDelectPlace(String delectPlace) {
        this.delectPlace = delectPlace;
    }

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public String getDetectUnit() {
        return detectUnit;
    }

    public void setDetectUnit(String detectUnit) {
        this.detectUnit = detectUnit;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReagent() {
        return reagent;
    }

    public void setReagent(String reagent) {
        this.reagent = reagent;
    }

    public String getReagentCop() {
        return reagentCop;
    }

    public void setReagentCop(String reagentCop) {
        this.reagentCop = reagentCop;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrumentCop() {
        return instrumentCop;
    }

    public void setInstrumentCop(String instrumentCop) {
        this.instrumentCop = instrumentCop;
    }

    public String getDetectUnitId() {
        return detectUnitId;
    }

    public void setDetectUnitId(String detectUnitId) {
        this.detectUnitId = detectUnitId;
    }
}
