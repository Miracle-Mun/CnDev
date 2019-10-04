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
@Table(name = "company_credit_grade")
@EntityListeners(AuditingEntityListener.class)


public class CompanyCreditGrade implements Serializable {
    @ApiModelProperty(value = "企业信用评级ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditGradeId;


    @ApiModelProperty(value = "统一社会信用代码")
    @NotNull
    @Length(max = 50, message = "*CredittName must have at max 50 characters")
    private String creditCode;

    @ApiModelProperty(value = "原信用评级（A:守信， B:基本守信，C:失信）")
    @NotNull
    @Length(max = 20, message = "*OriginalGrade must have at max 20 characters")
    private String originalGrade;

    @ApiModelProperty(value = "现信用评级（A:守信， B:基本守信，C:失信）")
    @Length(max = 20, message = "*CurrentGrade must have at max 20 characters")
    private String nowGrade;

    @ApiModelProperty(value = "待审批信用评级（A:守信， B:基本守信，C:失信）")
    @Length(max = 20, message = "*ApprovalGrade must have at max 20 characters")
    private String approvalGrade;

//    @Column(nullable = true)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
    @ApiModelProperty(value = "评级时间")
    private Date gradeTime;


    @ApiModelProperty(value = "评级单位名称")
    @NotNull
    @Length(max = 50, message = "*GradeUnit must have at max 50 characters")
    private String gradeUnit;

    public Long getCreditGradeId() {
        return creditGradeId;
    }

    public void setCreditGradeId(Long creditGradeId) {
        this.creditGradeId = creditGradeId;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getOriginalGrade() {
        return originalGrade;
    }

    public void setOriginalGrade(String originalGrade) {
        this.originalGrade = originalGrade;
    }

    public String getNowGrade() {
        return nowGrade;
    }

    public void setNowGrade(String nowGrade) {
        this.nowGrade = nowGrade;
    }

    public String getApprovalGrade() {
        return approvalGrade;
    }

    public void setApprovalGrade(String approvalGrade) {
        this.approvalGrade = approvalGrade;
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

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    @ApiModelProperty(value = "评级单位ID")
    @NotNull
    @Length(max = 20, message = "*gradeUnitId must have at max 20 characters")
    private String gradeUnitId;


    @ApiModelProperty(value = "审批状态（0：已拒绝，1：待审批 ，2：已审批）")
    @NotNull
    @Length(max = 20, message = "*ApprovalStatus must have at max 20 characters")
    private String approvalStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private int createUserId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private int updateUserId;

    @ApiModelProperty(value = "uploadFileName")
    private String uploadFileName;


    public Date getCreditAvailableStart() {
        return creditAvailableStart;
    }

    public void setCreditAvailableStart(Date creditAvailableStart) {
        this.creditAvailableStart = creditAvailableStart;
    }

    public Date getCreditAvailableEnd() {
        return creditAvailableEnd;
    }

    public void setCreditAvailableEnd(Date creditAvailableEnd) {
        this.creditAvailableEnd = creditAvailableEnd;
    }

    @ApiModelProperty(value = "评级有效起始日期")
    private Date creditAvailableStart;

    @ApiModelProperty(value = "评级有效截止日期")
    private Date creditAvailableEnd ;



}
