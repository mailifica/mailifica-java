package com.mailifica.services.batch;

import com.mailifica.core.net.HttpClient;
import com.mailifica.services.batch.model.CreateBatchEmailsResponse;
import com.mailifica.services.emails.model.CreateEmailOptions;
import java.util.List;

public class Batch {
    private final HttpClient httpClient;

    public Batch(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CreateBatchEmailsResponse send(List<CreateEmailOptions> options) {
        return httpClient.post("/emails/batch", options, CreateBatchEmailsResponse.class);
    }
}
