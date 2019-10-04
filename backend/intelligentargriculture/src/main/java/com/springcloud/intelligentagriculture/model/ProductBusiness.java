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
@Table(name = "product_business")
@EntityListeners(AuditingEntityListener.class)


public class ProductBusiness implements Serializable {
    @ApiModelProperty(value = "产品ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getAtunitprice() {
        return atunitprice;
    }

    public void setAtunitprice(Long atunitprice) {
        this.atunitprice = atunitprice;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getProductProfile() {
        return productProfile;
    }

    public void setProductProfile(String productProfile) {
        this.productProfile = productProfile;
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

    @ApiModelProperty(value = "产品名称")
    @Length(max = 50, message = "*ProductName must have at max 50 characters")
    private String productName;

    @ApiModelProperty(value = "单价")
    private Long atunitprice;

    @ApiModelProperty(value = "产地")
    @Length(max = 255, message = "*ProductArea must have at max 255 characters")
    private String productArea;

    @ApiModelProperty(value = "品种")
    @Length(max = 11, message = "*Variety must have at max 11 characters")
    private String variety;

    @ApiModelProperty(value = "规格")
    @Length(max = 11, message = "*Specification must have at max 11 characters")
    private String specification;

    @ApiModelProperty(value = "评级")
    @Length(max = 11, message = "*Grade must have at max 11 characters")
    private String grade;

    @ApiModelProperty(value = "经营主体ID : company_business")
    @NotNull
    private Long companyId;

    @ApiModelProperty(value = "产品介绍")
    @Length(max = 500, message = "*ProductProfile must have at max 500 characters")
    private String productProfile;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

}
