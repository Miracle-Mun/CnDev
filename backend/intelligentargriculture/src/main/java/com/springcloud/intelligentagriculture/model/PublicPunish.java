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
@Table(name = "public_punish")
@EntityListeners(AuditingEntityListener.class)


public class PublicPunish implements Serializable {
    @ApiModelProperty(value = "编号")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "行政处罚决定书文号")
    @NotNull
    @Length(max = 50, message = "*DocCode must have at max 50 characters")
    private String docCode;

    @ApiModelProperty(value = "处罚名称")
    @NotNull
    @Length(max = 50, message = "*PunishName must have at max 50 characters")
    private String punishName;

    @ApiModelProperty(value = "处罚类别1")
    @NotNull
    @Length(max = 50, message = "*PunishTypeF must have at max 50 characters")
    private String punishTypeF;

    @ApiModelProperty(value = "处罚类别2")
    @NotNull
    @Length(max = 50, message = "*PunishTypeS must have at max 50 characters")
    private String punishTypeS;

    @ApiModelProperty(value = "处罚事由")
    @NotNull
    @Length(max = 5000, message = "*punishReason must have at max 5000 characters")
    private String punishReason;

    @ApiModelProperty(value = "处罚依据")
    @NotNull
    @Length(max = 5000, message = "*punishFoundation must have at max 5000 characters")
    private String punishFoundation;

    @ApiModelProperty(value = "行政相对人名称")
    @NotNull
    @Length(max = 50, message = "*PunishObjectName must have at max 50 characters")
    private String punishObjectName;

    @ApiModelProperty(value = "行政相对人代码_1 (统一社会信用代码)")
    @NotNull
    @Length(max = 50, message = "*CreditCode must have at max 50 characters")
    private String creditCode;

    @ApiModelProperty(value = "行政相对人代码_2 (组织机构代码)")
    @NotNull
    @Length(max = 50, message = "*OrganizationCode must have at max 50 characters")
    private String organizationCode;

    @ApiModelProperty(value = "行政相对人代码_3 (工商登记码)")
    @NotNull
    @Length(max = 50, message = "*BusinessRegisterCode must have at max 50 characters")
    private String businessRegisterCode;

    @ApiModelProperty(value = "行政相对人代码_4 (税务登记号)")
    @NotNull
    @Length(max = 50, message = "*TaxRegisterCode must have at max 50 characters")
    private String taxRegisterCode;

    @ApiModelProperty(value = "行政相对人代码_5 (居民身份证号)")
    @NotNull
    @Length(max = 50, message = "*IdCode must have at max 50 characters")
    private String idCode;

    @ApiModelProperty(value = "法定代表人姓名")
    @NotNull
    @Length(max = 50, message = "*LegalName must have at max 50 characters")
    private String legalName;

    @ApiModelProperty(value = "处罚结果")
    @NotNull
    @Length(max = 5000, message = "*punishResult must have at max 5000 characters")
    private String punishResult;

    @ApiModelProperty(value = "处罚决定日期")
    @NotNull
    private Date punishDate;

    @ApiModelProperty(value = "处罚机关")
    @NotNull
    @Length(max=50, message = "*PunishUnit must have at max 50 characters")
    private String punishUnit;

    @ApiModelProperty(value = "当前状态")
    @NotNull
    @Length(max=20, message = "*Status must have at max 20 characters")
    private String status;

    @ApiModelProperty(value = "地方编码")
    @NotNull
    @Length(max=50, message = "*AddressCode must have at max 50 characters")
    private String addressCode;

    @ApiModelProperty(value = "数据更新时间戳")
    @NotNull
    @Length(max=50, message = "*UpdateDate must have at max 50 characters")
    private String updateDate;

    @ApiModelProperty(value = "备注")
    @NotNull
    @Length(max=5000, message = "*remarks must have at max 5000 characters")
    private String remarks;

    @ApiModelProperty(value = "信息使用范围")
    @NotNull
    @Length(max=50, message = "*InformationScope must have at max 50 characters")
    private String informationScope;


    @ApiModelProperty(value = "失信严重程度")
    @NotNull
    @Length(max=50, message = "*LoseCreditGrade must have at max 50 characters")
    private String loseCreditGrade;

    @ApiModelProperty(value = "公示截止日期")
    @NotNull
    private Date publicExpireDate;

    @ApiModelProperty(value = "创建人")
    @NotNull
    @Length(max=50, message = "*Creater must have at max 50 characters")
    private String creater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getPunishName() {
        return punishName;
    }

    public void setPunishName(String punishName) {
        this.punishName = punishName;
    }

    public String getPunishTypeF() {
        return punishTypeF;
    }

    public void setPunishTypeF(String punishTypeF) {
        this.punishTypeF = punishTypeF;
    }

    public String getPunishTypeS() {
        return punishTypeS;
    }

    public void setPunishTypeS(String punishTypeS) {
        this.punishTypeS = punishTypeS;
    }

    public String getPunishReason() {
        return punishReason;
    }

    public void setPunishReason(String punishReason) {
        this.punishReason = punishReason;
    }

    public String getPunishFoundation() {
        return punishFoundation;
    }

    public void setPunishFoundation(String punishFoundation) {
        this.punishFoundation = punishFoundation;
    }

    public String getPunishObjectName() {
        return punishObjectName;
    }

    public void setPunishObjectName(String punishObjectName) {
        this.punishObjectName = punishObjectName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getBusinessRegisterCode() {
        return businessRegisterCode;
    }

    public void setBusinessRegisterCode(String businessRegisterCode) {
        this.businessRegisterCode = businessRegisterCode;
    }

    public String getTaxRegisterCode() {
        return taxRegisterCode;
    }

    public void setTaxRegisterCode(String taxRegisterCode) {
        this.taxRegisterCode = taxRegisterCode;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getPunishResult() {
        return punishResult;
    }

    public void setPunishResult(String punishResult) {
        this.punishResult = punishResult;
    }

    public Date getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(Date punishDate) {
        this.punishDate = punishDate;
    }

    public String getPunishUnit() {
        return punishUnit;
    }

    public void setPunishUnit(String punishUnit) {
        this.punishUnit = punishUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInformationScope() {
        return informationScope;
    }

    public void setInformationScope(String informationScope) {
        this.informationScope = informationScope;
    }

    public String getLoseCreditGrade() {
        return loseCreditGrade;
    }

    public void setLoseCreditGrade(String loseCreditGrade) {
        this.loseCreditGrade = loseCreditGrade;
    }

    public Date getPublicExpireDate() {
        return publicExpireDate;
    }

    public void setPublicExpireDate(Date publicExpireDate) {
        this.publicExpireDate = publicExpireDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModelProperty(value = "创建时间")
    @NotNull
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    @NotNull
    @Length(max=50, message = "*Updater must have at max 50 characters")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    @NotNull
    private Date updateTime;
}
