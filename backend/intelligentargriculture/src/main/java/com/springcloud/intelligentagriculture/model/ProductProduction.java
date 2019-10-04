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
@Table(name = "product_production")
@EntityListeners(AuditingEntityListener.class)


public class ProductProduction implements Serializable {


    @ApiModelProperty(value = "产品ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ApiModelProperty(value = "产品名称")
    @Length(max = 50, message = "*productName must have at max 50 characters")
    private String productName;

    @ApiModelProperty(value = "是否为有机产品(0:否,1:是)")
    @Length(max = 11, message = "*doOrganic must have at max 11 characters")
    private String doOrganic;

    @ApiModelProperty(value = "单价")
    private float atunitprice;

    @ApiModelProperty(value = "产地")
    @Length(max = 255, message = "*productArea must have at max 255 characters")
    private String productArea;

    @ApiModelProperty(value = "品种")
    @Length(max = 11, message = "*variety must have at max 11 characters")
    private String variety;

    @ApiModelProperty(value = "规格")
    @Length(max = 11, message = "*specification must have at max 11 characters")
    private String specification;

    @ApiModelProperty(value = "评级")
    @Length(max = 11, message = "*grade must have at max 11 characters")
    private String grade;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDoOrganic() {
        return doOrganic;
    }

    public void setDoOrganic(String doOrganic) {
        this.doOrganic = doOrganic;
    }

    public float getAtunitprice() {
        return atunitprice;
    }

    public void setAtunitprice(float atunitprice) {
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
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

    @ApiModelProperty(value = "生产主体ID : company_production")
    private int companyId;

    @ApiModelProperty(value = "产品介绍")
    @Length(max = 500, message = "*productProfile must have at max 500 characters")
    private String productProfile;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private int createUserId;


    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private int updateUserId;

}
