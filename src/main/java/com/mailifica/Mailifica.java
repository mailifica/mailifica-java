package com.mailifica;

import com.mailifica.core.net.HttpClient;
import com.mailifica.services.apikeys.ApiKeys;
import com.mailifica.services.batch.Batch;
import com.mailifica.services.domains.Domains;
import com.mailifica.services.emails.Emails;

public class Mailifica {
    private final HttpClient httpClient;
    private final Emails emails;
    private final Batch batch;
    private final Domains domains;
    private final ApiKeys apiKeys;

    public Mailifica() {
        this(System.getenv("MAILIFICA_API_KEY"));
    }

    public Mailifica(String apiKey) {
        this(apiKey, System.getenv("MAILIFICA_BASE_URL") != null ? System.getenv("MAILIFICA_BASE_URL") : "https://api.mailifica.com/v1");
    }

    public Mailifica(String apiKey, String baseUrl) {
        this.httpClient = new HttpClient(apiKey, baseUrl);
        this.emails = new Emails(this.httpClient);
        this.batch = new Batch(this.httpClient);
        this.domains = new Domains(this.httpClient);
        this.apiKeys = new ApiKeys(this.httpClient);
    }

    public Emails emails() {
        return this.emails;
    }

    public Batch batch() {
        return this.batch;
    }

    public Domains domains() {
        return this.domains;
    }

    public ApiKeys apiKeys() {
        return this.apiKeys;
    }
}
