package com.mailifica.services.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailifica.core.net.HttpClient;
import com.mailifica.services.domains.model.Domain;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Domains {
    private final HttpClient httpClient;

    public Domains(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public static class DomainListResponse {
        @JsonProperty("data")
        private List<Domain> data;

        public List<Domain> getData() { return data; }
        public void setData(List<Domain> data) { this.data = data; }
    }

    public Domain create(String name) {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        return httpClient.post("/domains", payload, Domain.class);
    }

    public List<Domain> list() {
        DomainListResponse resp = httpClient.get("/domains", DomainListResponse.class);
        return resp != null ? resp.getData() : List.of();
    }

    public Domain get(String domainId) {
        return httpClient.get("/domains/" + domainId, Domain.class);
    }

    public Domain verify(String domainId) {
        return httpClient.post("/domains/" + domainId + "/verify", new HashMap<>(), Domain.class);
    }

    public void remove(String domainId) {
        httpClient.delete("/domains/" + domainId);
    }
}
