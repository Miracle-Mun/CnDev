package com.springcloud.intelligentagriculture.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "common_word ")
@EntityListeners(AuditingEntityListener.class)


public class CommonWord implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @ApiModelProperty(value = "常用语ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "常用语")
    @NotNull
    @Length(max = 128, message = "*word must have at max 128 characters")
    private String word;
}


