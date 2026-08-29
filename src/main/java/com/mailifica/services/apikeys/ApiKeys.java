package com.mailifica.services.apikeys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailifica.core.net.HttpClient;
import com.mailifica.services.apikeys.model.ApiKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiKeys {
    private final HttpClient httpClient;

    public ApiKeys(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public static class ApiKeyListResponse {
        @JsonProperty("data")
        private List<ApiKey> data;

        public List<ApiKey> getData() { return data; }
        public void setData(List<ApiKey> data) { this.data = data; }
    }

    public ApiKey create(String name, String permission) {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        if (permission != null) {
            payload.put("permission", permission);
        }
        return httpClient.post("/api-keys", payload, ApiKey.class);
    }

    public List<ApiKey> list() {
        ApiKeyListResponse resp = httpClient.get("/api-keys", ApiKeyListResponse.class);
        return resp != null ? resp.getData() : List.of();
    }

    public void remove(String apiKeyId) {
        httpClient.delete("/api-keys/" + apiKeyId);
    }
}
