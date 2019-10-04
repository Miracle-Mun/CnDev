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
@Table(name = "blacklist")
@EntityListeners(AuditingEntityListener.class)


public class Blacklist implements Serializable {
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

    public String getBlacklistType() {
        return blacklistType;
    }

    public void setBlacklistType(String blacklistType) {
        this.blacklistType = blacklistType;
    }

    public String getNowGrade() {
        return nowGrade;
    }

    public void setNowGrade(String nowGrade) {
        this.nowGrade = nowGrade;
    }

    public Date getGradeTime() {
        return gradeTime;
    }

    public void setGradeTime(Date gradeTime) {
        this.gradeTime = gradeTime;
    }

    public String getGradeUnit() {
        return gradeUnit;
    }

    public void setGradeUnit(String gradeUnit) {
        this.gradeUnit = gradeUnit;
    }

    public String getGradeUnitId() {
        return gradeUnitId;
    }

    public void setGradeUnitId(String gradeUnitId) {
        this.gradeUnitId = gradeUnitId;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(long updateUserId) {
        this.updateUserId = updateUserId;
    }

    @ApiModelProperty(value = "红黑ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "统一社会信用代码")
    @NotNull
    @Length(max = 50, message = "*CreditCode must have at max 50 characters")
    private String creditCode;

    @ApiModelProperty(value = "红黑类型 (1:红名单, 2:黑名单)")
    @NotNull
    @Length(max = 20, message = "*BlackListType must have at max 20 characters")
    private String blacklistType;

    @ApiModelProperty(value = "现信用评级（A:守信， B:基本守信，C:失信）")
    @Length(max = 20, message = "*CurrentGrade must have at max 20 characters")
    private String nowGrade;


    @ApiModelProperty(value = "评级时间")
    private Date gradeTime;

    @ApiModelProperty(value = "评级单位名称")
    @NotNull
    @Length(max = 50, message = "*GradeUnit must have at max 50 characters")
    private String gradeUnit;

    @ApiModelProperty(value = "评级单位ID")
    @NotNull
    @Length(max = 20, message = "*gradeUnitId must have at max 20 characters")
    private String gradeUnitId;

    @ApiModelProperty(value = "审批状态（0：正常，1：待审批 ，2：已审批）")
    @Length(max = 20, message = "*ApprovalStatus must have at max 20 characters")
    private String approvalStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    @Length(max = 32, message = "*createUserId must have indentity for creating user")
    private long createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    @Length(max = 32, message = "*updateUserId must have indentity for updating user")
    private long updateUserId;
}
