package com.smw.velloredemo.dao;


import javax.persistence.*;

@Entity
@Table(name = "aoi")
public class AreaofInterest {
    public AreaofInterest() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column(name="suggestion")
    private String suggestion;


    @Column(name="normalized_skill_name")
    private String normalized_skill_name;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getNormalized_skill_name() {
        return normalized_skill_name;
    }

    public void setNormalized_skill_name(String normalized_skill_name) {
        this.normalized_skill_name = normalized_skill_name;
    }
}
