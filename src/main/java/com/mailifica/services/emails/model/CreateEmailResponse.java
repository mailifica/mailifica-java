package com.mailifica.services.emails.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmailResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    public CreateEmailResponse() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
