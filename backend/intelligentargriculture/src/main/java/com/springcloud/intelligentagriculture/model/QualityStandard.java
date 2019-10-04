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
@Table(name = "quality_standard")
@EntityListeners(AuditingEntityListener.class)


public class QualityStandard implements Serializable {
    @ApiModelProperty(value = "三品一标主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "行政相对人代码_1 (统一社会信用代码)")
    @NotNull
    @Length(max = 50, message = "*CreditCode must have at max 50 characters")
    private String creditCode;

    @ApiModelProperty(value = "认证类型（1：无公害产品，2：绿色食品，3：有机食品，4：地理标志）")
    @NotNull
    @Length(max = 50, message = "*CretficationType must have at max 50 characters")
    private String cretficationType;

    @ApiModelProperty(value = "产品ID : product_production")
    @NotNull
    @Length(max = 50, message = "*ProductId must have indentify of product")
    private Long productId;

    @ApiModelProperty(value = "认证类别(1:)")
    @Length(max = 50, message = "*CretficationCategory must have at max 50 characters")
    private String cretficationCategory;

    @ApiModelProperty(value = "农业分类(1:养殖业，2：畜牧业，3：种植业)")
    @Length(max = 50, message = "*ArgriculturalClassification must have at max 50 characters")
    private String argriculturalClassification;

    @ApiModelProperty(value = "认证开始时间")
    private Date certificationStartTime;

    @ApiModelProperty(value = "认证到期时间")
    private Date certificationEndTime;

    @ApiModelProperty(value = "证书编号")
    @Length(max = 64, message = "*certificationNo must have at max 64 characters")
    private String certificationNo;

    public String getCertificationNo() {
        return certificationNo;
    }

    public void setCertificationNo(String certificationNo) {
        this.certificationNo = certificationNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCretficationType() {
        return cretficationType;
    }

    public void setCretficationType(String cretficationType) {
        this.cretficationType = cretficationType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCretficationCategory() {
        return cretficationCategory;
    }

    public void setCretficationCategory(String cretficationCategory) {
        this.cretficationCategory = cretficationCategory;
    }

    public String getArgriculturalClassification() {
        return argriculturalClassification;
    }

    public void setArgriculturalClassification(String argriculturalClassification) {
        this.argriculturalClassification = argriculturalClassification;
    }

    public Date getCertificationStartTime() {
        return certificationStartTime;
    }

    public void setCertificationStartTime(Date certificationStartTime) {
        this.certificationStartTime = certificationStartTime;
    }

    public Date getCertificationEndTime() {
        return certificationEndTime;
    }

    public void setCertificationEndTime(Date certificationEndTime) {
        this.certificationEndTime = certificationEndTime;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    @ApiModelProperty(value = "产量")
    @Length(max = 50, message = "*Output must have at max 50 characters")
    private String output;

    @ApiModelProperty(value = "附件")
    @Length(max = 500, message = "*Files must have at max 500 characters")
    private String files;

    @ApiModelProperty(value = "创建时间")
    @NotNull
    private Date createDate;

    @ApiModelProperty(value = "创建人")
    @NotNull
    @Length(max=50, message = "*Creater must have at max 50 characters")
    private String creater;

    @ApiModelProperty(value = "更新人")
    @NotNull
    @Length(max=50, message = "*Updater must have at max 50 characters")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    @NotNull
    private Date updateDate;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    @Length(max = 32, message = "*CreateUserId must have identify for create user")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    @Length(max = 32, message = "*UpdateUserId must have identify for update user")
    private Long updateUserId;

}
