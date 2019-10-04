package com.springcloud.intelligentagriculture.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "town")
@EntityListeners(AuditingEntityListener.class)


public class Town implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long divisionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(Long divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperviseSystem() {
        return superviseSystem;
    }

    public void setSuperviseSystem(String superviseSystem) {
        this.superviseSystem = superviseSystem;
    }

    @Length(max = 40, message = "*name must have at max 50 characters")
    private String name;

    @Length(max = 2000, message = "*superviseSystem must have at max 2000 characters")
    private String superviseSystem;

}