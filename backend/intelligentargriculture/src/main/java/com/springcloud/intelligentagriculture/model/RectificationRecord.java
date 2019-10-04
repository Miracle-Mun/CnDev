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
@Table(name = "rectification_record")
@EntityListeners(AuditingEntityListener.class)


public class RectificationRecord implements Serializable {
    @ApiModelProperty(value = "整改记录ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "乡镇ID : town")
    private Long townId;

    @ApiModelProperty(value = "企业ID : company_production")
    private Long companyId;

    @ApiModelProperty(value = "整改记录时间")
    private Date rectificationRecordTime;

    @ApiModelProperty(value = "检查人")
    @Length(max = 50, message = "*Inspector must have at max 50 characters")
    private String inspector;

    @ApiModelProperty(value = "结论（0:不合格,1:合格）")
    @Length(max = 255, message = "*Conclusion must have at max 255 characters")
    private String conclusion;

    @ApiModelProperty(value = "不合格检查 : {order:xxx, suggestion:xxx, others:xxx}")
    @NotNull
    @Length(max = 512, message = "*ConclusionFalseInfo have at max 512 characters of utf8 or utf8_unicode_ci ")
    private String conclusionFalseInfo;

    @ApiModelProperty(value = "现场照片")
    @Length(max = 255, message = "*ScenePhotos must have at max 255 characters")
    private String scenePhotos;

    @ApiModelProperty(value = "监管人签名")
    @Length(max = 255, message = "*SupervisionSign must have at max 255 characters")
    private String supervisionSign;

    @ApiModelProperty(value = "确认人签名")
    @Length(max = 255, message = "*ConfirmorSign must have at max 255 characters")
    private String confirmorSign;

    @ApiModelProperty(value = "监管记录ID : supervision_record")
    @NotNull
    private Long supervisionRecordId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRectificationRecordTime() {
        return rectificationRecordTime;
    }

    public void setRectificationRecordTime(Date rectificationRecordTime) {
        this.rectificationRecordTime = rectificationRecordTime;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
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

    public String getSupervisionSign() {
        return supervisionSign;
    }

    public void setSupervisionSign(String supervisionSign) {
        this.supervisionSign = supervisionSign;
    }

    public String getConfirmorSign() {
        return confirmorSign;
    }

    public void setConfirmorSign(String confirmorSign) {
        this.confirmorSign = confirmorSign;
    }

    public Long getSupervisionRecordId() {
        return supervisionRecordId;
    }

    public void setSupervisionRecordId(Long supervisionRecordId) {
        this.supervisionRecordId = supervisionRecordId;
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
}
