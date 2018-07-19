package com.jfz.model;

import java.util.Date;

public class rabbitMessage {
    private Long id;

    private String exchange;

    private String routingKey;

    private Date createTime;

    private Short messageType;

    private String remark;

    private String host;

    private String erpTable;

    private Long erpId;

    private String context;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey == null ? null : routingKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getMessageType() {
        return messageType;
    }

    public void setMessageType(Short messageType) {
        this.messageType = messageType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getErpTable() {
        return erpTable;
    }

    public void setErpTable(String erpTable) {
        this.erpTable = erpTable == null ? null : erpTable.trim();
    }

    public Long getErpId() {
        return erpId;
    }

    public void setErpId(Long erpId) {
        this.erpId = erpId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}