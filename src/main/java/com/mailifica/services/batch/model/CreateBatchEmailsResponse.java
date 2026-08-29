package com.mailifica.services.batch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailifica.services.emails.model.CreateEmailResponse;
import java.util.List;

public class CreateBatchEmailsResponse {
    @JsonProperty("data")
    private List<CreateEmailResponse> data;

    public CreateBatchEmailsResponse() {}

    public List<CreateEmailResponse> getData() { return data; }
    public void setData(List<CreateEmailResponse> data) { this.data = data; }
}
