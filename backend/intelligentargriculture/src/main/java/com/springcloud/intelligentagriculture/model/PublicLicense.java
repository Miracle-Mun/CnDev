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
import java.sql.Blob;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "public_license")
@EntityListeners(AuditingEntityListener.class)


public class PublicLicense implements Serializable {
    @ApiModelProperty(value = "编号")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "行政许可决定书文号")
    @NotNull
    @Length(max = 50, message = "*DocCode must have at max 50 characters")
    private String docCode;

    @ApiModelProperty(value = "项目名称")
    @NotNull
    @Length(max = 50, message = "*ProjectName must have at max 50 characters")
    private String projectName;

    @ApiModelProperty(value = "行政许可编码")
    @NotNull
    @Length(max = 50, message = "*LicenseCode must have at max 50 characters")
    private String licenseCode;

    @ApiModelProperty(value = "审批类别")
    @NotNull
    @Length(max = 50, message = "*ApprovalContent must have at max 50 characters")
    private String approvalContent;

    @ApiModelProperty(value = "许可内容")
    @NotNull
    @Length(max = 5000, message = "*permitContent must have at max 5000 characters")
    private String permitContent;

    @ApiModelProperty(value = "行政相对人名称")
    @NotNull
    @Length(max = 50, message = "*PublishObjectName must have at max 50 characters")
    private String publishObjectName;

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
    @Length(max = 5000, message = "*remarks must have at max 5000 characters")
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

    @ApiModelProperty(value = "创建时间")
    @NotNull
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    @NotNull
    @Length(max=50, message = "*Updater must have at max 50 characters")
    private String updater;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent;
    }

    public String getPermitContent() {
        return permitContent;
    }

    public void setPermitContent(String permitContent) {
        this.permitContent = permitContent;
    }

    public String getPublishObjectName() {
        return publishObjectName;
    }

    public void setPublishObjectName(String publishObjectName) {
        this.publishObjectName = publishObjectName;
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

    @ApiModelProperty(value = "更新时间")
    @NotNull
    private Date updateTime;
}
