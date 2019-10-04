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
@Table(name = "supervision_record")
@EntityListeners(AuditingEntityListener.class)


public class SupervisionRecord implements Serializable {
    @ApiModelProperty(value = "监管记录ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "生产主体类型(1:企业 2：农户)")
    @NotNull
    @Length(max = 50, message = "*ProductionSubjectType must have at max 50 characters")
    private String productionSubjectType;

    @ApiModelProperty(value = "乡镇ID : town")
    private Long townId;

    @ApiModelProperty(value = "企业ID : company_production")
    private Long companyId;

    @ApiModelProperty(value = "监管记录时间")
    private Date supervisionRecordTime;

    @ApiModelProperty(value = "检查人")
    @Length(max = 50, message = "*Inspector must have at max 50 characters")
    private String inspector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductionSubjectType() {
        return productionSubjectType;
    }

    public void setProductionSubjectType(String productionSubjectType) {
        this.productionSubjectType = productionSubjectType;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getSupervisionRecordTime() {
        return supervisionRecordTime;
    }

    public void setSupervisionRecordTime(Date supervisionRecordTime) {
        this.supervisionRecordTime = supervisionRecordTime;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getUsefulExpressions() {
        return usefulExpressions;
    }

    public void setUsefulExpressions(String usefulExpressions) {
        this.usefulExpressions = usefulExpressions;
    }

    public String getOtherProblems() {
        return otherProblems;
    }

    public void setOtherProblems(String otherProblems) {
        this.otherProblems = otherProblems;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getConclusionFalseInfo() {
        return conclusionFalseInfo;
    }

    public void setConclusionFalseInfo(String conclusionFalseInfo) {
        this.conclusionFalseInfo = conclusionFalseInfo;
    }

    public String getScenePhotos() {
        return scenePhotos;
    }

    public void setScenePhotos(String scenePhotos) {
        this.scenePhotos = scenePhotos;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSupervisionInfo() {
        return supervisionInfo;
    }

    public void setSupervisionInfo(String supervisionInfo) {
        this.supervisionInfo = supervisionInfo;
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

    @ApiModelProperty(value = "常用语")
    @Length(max = 255, message = "*UsefulExpressions must have at max 255 characters")
    private String usefulExpressions;

    @ApiModelProperty(value = "现场发现的其他问题")
    @Length(max = 255, message = "*OtherProblems must have at max 255 characters")
    private String otherProblems;

    @ApiModelProperty(value = "结论（0:不合格,1:合格）")
    @Length(max = 255, message = "*Conclusion must have at max 255 characters")
    private String conclusion;

    @ApiModelProperty(value = "不合格检查 : {order:xxx, suggestion:xxx, others:xxx}")
    @NotNull
    @Length(max = 512, message = "*ConclusionFalseInfo must have at max 512 characters")
    private String conclusionFalseInfo;

    @ApiModelProperty(value = "现场照片")
    @Length(max = 500, message = "*ScenePhotos must have at max 500 characters")
    private String scenePhotos;

    @ApiModelProperty(value = "签名")
    @Length(max = 500, message = "*Sign must have at max 500 characters")
    private String sign;

    @ApiModelProperty(value = "检查内容与结果 : {production:1, input:1, abuse:1, origin:1, inspection:1, standard:1}")
    @Length(max = 2000, message = "*Sign must have at max 2000 characters")
    private String supervisionInfo;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    public Long getSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(Long specialFlag) {
        this.specialFlag = specialFlag;
    }

    @ApiModelProperty(value = "专项")
    private Long specialFlag;

}
