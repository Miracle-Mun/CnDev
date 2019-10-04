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
@Table(name = "company_production")
@EntityListeners(AuditingEntityListener.class)


public class CompanyProduction implements Serializable {
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    public String getAgriculturalClassification() {
        return agriculturalClassification;
    }

    public void setAgriculturalClassification(String agriculturalClassification) {
        this.agriculturalClassification = agriculturalClassification;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public float getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(float plantArea) {
        this.plantArea = plantArea;
    }

    public String getLandSource() {
        return landSource;
    }

    public void setLandSource(String landSource) {
        this.landSource = landSource;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getQualityStandardId() {
        return qualityStandardId;
    }

    public void setQualityStandardId(int qualityStandardId) {
        this.qualityStandardId = qualityStandardId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getCompanyHonor() {
        return companyHonor;
    }

    public void setCompanyHonor(String companyHonor) {
        this.companyHonor = companyHonor;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDoSupervision() {
        return doSupervision;
    }

    public void setDoSupervision(String doSupervision) {
        this.doSupervision = doSupervision;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(int updateUserId) {
        this.updateUserId = updateUserId;
    }

    @ApiModelProperty(value = "生产主体ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @ApiModelProperty(value = "行政相对人代码_1 (统一社会信用代码)")
    @NotNull
    @Length(max = 50, message = "*CredittName must have at max 50 characters")
    private String creditCode;

    @ApiModelProperty(value = "生产主体类型(1:企业 2：农户)")
    @NotNull
    @Length(max = 50, message = "*OriginalGrade must have at max 50 characters")
    private String companyType;

    @ApiModelProperty(value = "乡镇ID")
    private int townId;

    @ApiModelProperty(value = "农业分类(1:养殖业，2：畜牧业，3：种植业)")
    @Length(max = 255, message = "*agriculturalClassification must have at max 255 characters")
    private String agriculturalClassification;

    @ApiModelProperty(value = "单位名称")
    @Length(max = 50, message = "*companyName must have at max 50 characters")
    private String companyName;

    @ApiModelProperty(value = "负责人(农户姓名)")
    @Length(max = 50, message = "*chargePerson must have at max 50 characters")
    private String chargePerson;

    @ApiModelProperty(value = "联系方式 : (COMPANY_TYPE=2 农户)")
    @Length(max = 255, message = "*contactWay must have at max 255 characters")
    private String contactWay;

    @ApiModelProperty(value = "种养殖面积(亩) : (COMPANY_TYPE=2 农户)")
    private float plantArea;

    @ApiModelProperty(value = "土地来源 : (COMPANY_TYPE=2 农户)")
    @Length(max = 255, message = "*landSource must have at max 255 characters")
    private String landSource;

    @ApiModelProperty(value = "地址")
    @Length(max = 50, message = "*companyAddress must have at max 50 characters")
    private String companyAddress;

    @ApiModelProperty(value = "生产主体产品信息 ({planting : {name:xxx, area:10}, aquatic : {name:xxx, area:10}, livestock : {name:xxx, area:10}, poultry : {name:xxx, area:10}})")
    @Length(max = 2000, message = "*productInfo must have at max 2000 characters")
    private String productInfo;

    @ApiModelProperty(value = "三品认证ID : quality_standard")
    private int qualityStandardId;

    @ApiModelProperty(value = "联系人")
    @Length(max = 50, message = "*contactPerson must have at max 50 characters")
    private String contactPerson;

    @ApiModelProperty(value = "联系人手机")
    private String contactMobile;


    @ApiModelProperty(value = "企业荣誉")
    @Length(max = 255, message = "*companyHonor must have at max 255 characters")
    private String companyHonor;

    @ApiModelProperty(value = "备注")
    @Length(max = 255, message = "*remarks must have at max 255 characters")
    private String remarks;

    @ApiModelProperty(value = "是否监管(0:否,1:是)")
    @Length(max = 50, message = "*doSupervision must have at max 50 characters")
    private String doSupervision;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public int getPublic_license() {
        return public_license;
    }

    public void setPublic_license(int public_license) {
        this.public_license = public_license;
    }

    @ApiModelProperty(value = "创建人")
    private int createUserId;


    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private int updateUserId;


    @ApiModelProperty(value = "更新人")
    private int public_license;

    @ApiModelProperty(value = "更新人")
    private int public_punish;

    public int getPublic_punish() {
        return public_punish;
    }

    public void setPublic_punish(int public_punish) {
        this.public_punish = public_punish;
    }

    public int getQuality_standard() {
        return quality_standard;
    }

    public void setQuality_standard(int quality_standard) {
        this.quality_standard = quality_standard;
    }

    @ApiModelProperty(value = "更新人")
    private int quality_standard;
}
