package com.mailifica.services.domains.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Domain {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("region")
    private String region;

    @JsonProperty("records")
    private List<DomainRecord> records;

    @JsonProperty("created_at")
    private String createdAt;

    public Domain() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public List<DomainRecord> getRecords() { return records; }
    public void setRecords(List<DomainRecord> records) { this.records = records; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
