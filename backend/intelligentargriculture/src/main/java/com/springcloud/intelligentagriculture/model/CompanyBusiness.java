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
@Table(name = "company_business")
@EntityListeners(AuditingEntityListener.class)


public class CompanyBusiness implements Serializable {
    @ApiModelProperty(value = "经营主体ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "企业名称")
    @Length(max = 50, message = "*CompanyName must have at max 50 characters")
    private String companyName;

    @ApiModelProperty(value = "企业规模(1:小型企业,2:中型企业,3:大型企业)")
    @Length(max = 11, message = "*CompanyScale must have at max 11 characters")
    private String companyScale;

    @ApiModelProperty(value = "产品类型")
    @Length(max = 11, message = "*ProductType must have at max 11 characters")
    private String productType;

    @ApiModelProperty(value = "法人")
    @Length(max = 50, message = "*LegalPerson must have at max 50 characters")
    private String legalPerson;

    @ApiModelProperty(value = "企业地址")
    @Length(max = 255, message = "*LegalPerson must have at max 255 characters")
    private String companyAddress;

    @ApiModelProperty(value = "行政相对人代码_1 (统一社会信用代码)")
    @NotNull
    @Length(max = 255, message = "*CreditCode must have at max 255 characters")
    private String creditCode;

    @ApiModelProperty(value = "联系方式 : (COMPANY_TYPE=2 农户)")
    @Length(max = 255, message = "*ContactWay must have at max 255 characters")
    private String contactWay;

    @ApiModelProperty(value = "监管对象性质(1:法人,2:其他组织)")
    @Length(max = 255, message = "*SupervisionNature must have at max 255 characters")
    private String supervisionNature;

    @ApiModelProperty(value = "公司简介")
    @Length(max = 255, message = "*CompanyProfile must have at max 255 characters")
    private String companyProfile;

    @ApiModelProperty(value = "作业图片")
    @NotNull
    @Length(max = 255, message = "*ProfileImage must have at max 255 characters")
    private String  profileImage;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getSupervisionNature() {
        return supervisionNature;
    }

    public void setSupervisionNature(String supervisionNature) {
        this.supervisionNature = supervisionNature;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

}
