package com.mailifica.services.domains.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DomainRecord {
    @JsonProperty("record")
    private String record;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    @JsonProperty("status")
    private String status;

    @JsonProperty("priority")
    private Integer priority;

    public DomainRecord() {}

    public String getRecord() { return record; }
    public void setRecord(String record) { this.record = record; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
}
