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
@Table(name = "warehouse")
@EntityListeners(AuditingEntityListener.class)


public class Warehouse implements Serializable {
    @ApiModelProperty(value = "仓库ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "仓库名称")
    @Length(max = 255, message = "*WarehouseName must have at max 255 characters")
    private String warehouseName;

    @ApiModelProperty(value = "仓库地址")
    @Length(max = 255, message = "*WarehouseAddress must have at max 255 characters")
    private String warehouseAddress;

    @ApiModelProperty(value = "仓库面积")
    private Long warehouseArea;

    @ApiModelProperty(value = "仓库规模")
    @Length(max = 255, message = "*WarehouseScope must have at max 255 characters")
    private String warehouseScope;

    @ApiModelProperty(value = "生产主体ID : company_production")
    @NotNull
    private Long companyId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public Long getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(Long warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public String getWarehouseScope() {
        return warehouseScope;
    }

    public void setWarehouseScope(String warehouseScope) {
        this.warehouseScope = warehouseScope;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
