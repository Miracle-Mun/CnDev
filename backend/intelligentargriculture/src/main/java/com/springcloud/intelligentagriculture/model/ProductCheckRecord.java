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
@Table(name = "product_check_record")
@EntityListeners(AuditingEntityListener.class)


public class ProductCheckRecord implements Serializable {
    @ApiModelProperty(value = "第三方抽检记录ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getProductCheckTime() {
        return productCheckTime;
    }

    public void setProductCheckTime(Date productCheckTime) {
        this.productCheckTime = productCheckTime;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getDetermine() {
        return determine;
    }

    public void setDetermine(String determine) {
        this.determine = determine;
    }

    public String getCheckStandard() {
        return checkStandard;
    }

    public void setCheckStandard(String checkStandard) {
        this.checkStandard = checkStandard;
    }

    public String getCheckOrganization() {
        return checkOrganization;
    }

    public void setCheckOrganization(String checkOrganization) {
        this.checkOrganization = checkOrganization;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    @ApiModelProperty(value = "抽检时间")
    private Date productCheckTime;

    @ApiModelProperty(value = "样品")
    @Length(max = 50, message = "*Specimen must have at max 50 characters")
    private String specimen;

    @ApiModelProperty(value = "检测项目")
    @Length(max = 255, message = "*CheckItem must have at max 255 characters")
    private String checkItem;

    @ApiModelProperty(value = "检测结果(1:阴性,2:阳性)")
    @Length(max = 255, message = "*CheckResult must have at max 255 characters")
    private String checkResult;

    @ApiModelProperty(value = "判定(1:合格,0:不合格)")
    @Length(max = 255, message = "*Determine must have at max 255 characters")
    private String determine;

    @ApiModelProperty(value = "检测标准")
    @Length(max = 255, message = "*CheckStandard must have at max 255 characters")
    private String checkStandard;

    @ApiModelProperty(value = "检测机构")
    @Length(max = 255, message = "*CheckOrganization must have at max 255 characters")
    private String checkOrganization;

    @ApiModelProperty(value = "产品ID : product_production")
    private Long productId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

}
