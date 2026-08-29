package com.mailifica.services.emails.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment {
    @JsonProperty("filename")
    private String filename;

    @JsonProperty("content")
    private String content;

    @JsonProperty("path")
    private String path;

    @JsonProperty("content_type")
    private String contentType;

    public Attachment() {}

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
}
