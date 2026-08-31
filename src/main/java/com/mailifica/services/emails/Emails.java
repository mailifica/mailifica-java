package com.mailifica.services.emails;

import com.mailifica.core.net.HttpClient;
import com.mailifica.services.emails.model.CreateEmailOptions;
import com.mailifica.services.emails.model.CreateEmailResponse;
import com.mailifica.services.emails.model.Email;
import java.util.HashMap;
import java.util.Map;

public class Emails {
    private final HttpClient httpClient;

    public Emails(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CreateEmailResponse send(CreateEmailOptions options) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("from", options.getFrom());
        if (options.getTo() != null && !options.getTo().isEmpty()) {
            payload.put("to", options.getTo().get(0));
        }
        payload.put("subject", options.getSubject());
        if (options.getHtml() != null) payload.put("html", options.getHtml());
        if (options.getText() != null) payload.put("text", options.getText());
        if (options.getReplyTo() != null) payload.put("reply_to", options.getReplyTo());
        return httpClient.post("/emails", payload, CreateEmailResponse.class);
    }

    public Email get(String emailId) {
        return httpClient.get("/emails/" + emailId, Email.class);
    }
}
