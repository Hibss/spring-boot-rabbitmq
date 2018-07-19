package com.jfz.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import groovy.transform.builder.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author steven.sheng
 */
@Data
@Builder
public class RabbitMessage implements Serializable {
    private Long id;

    private String exchange;

    private String routingKey;

    private String context;

    private Short messageType;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private String remark;

    private String host;

    private String erpTable;

    private Long erpId;
}