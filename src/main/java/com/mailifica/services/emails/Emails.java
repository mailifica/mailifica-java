package com.mailifica.services.emails;

import com.mailifica.core.net.HttpClient;
import com.mailifica.services.emails.model.CreateEmailOptions;
import com.mailifica.services.emails.model.CreateEmailResponse;
import com.mailifica.services.emails.model.Email;

public class Emails {
    private final HttpClient httpClient;

    public Emails(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CreateEmailResponse send(CreateEmailOptions options) {
        return httpClient.post("/emails", options, CreateEmailResponse.class);
    }

    public Email get(String emailId) {
        return httpClient.get("/emails/" + emailId, Email.class);
    }
}
