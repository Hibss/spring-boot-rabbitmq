package com.jfz.model;

import groovy.transform.builder.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author steven.sheng
 */
@Data
@Builder
public class Operator implements Serializable {
    private Long id;

    private String name;

    private String card;

    private String mobile;

    private Long uid;

    private String org;

    private Short isDelete;

    private Short rowState;

    private Long ownerId;

    private String ownerName;

    private String creatorName;

    private Long creatorId;

    private Date createTime;

    private Date updateTime;

    private String updatorName;

    private Long updatorId;

    private Integer manageCount;

    private Short isSignup;

    private Short isMinister;

    private Short isQualification;
}