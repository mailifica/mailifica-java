package com.mailifica.services.emails.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateEmailOptions {

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private List<String> to;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("html")
    private String html;

    @JsonProperty("text")
    private String text;

    @JsonProperty("cc")
    private List<String> cc;

    @JsonProperty("bcc")
    private List<String> bcc;

    @JsonProperty("reply_to")
    private String replyTo;

    @JsonProperty("headers")
    private Map<String, String> headers;

    @JsonProperty("attachments")
    private List<Attachment> attachments;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("scheduled_at")
    private String scheduledAt;

    public CreateEmailOptions() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String from;
        private List<String> to = new ArrayList<>();
        private String subject;
        private String html;
        private String text;
        private List<String> cc;
        private List<String> bcc;
        private String replyTo;
        private Map<String, String> headers;
        private List<Attachment> attachments;
        private List<Tag> tags;
        private String scheduledAt;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to.add(to);
            return this;
        }

        public Builder to(List<String> to) {
            this.to = to;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder html(String html) {
            this.html = html;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder cc(List<String> cc) {
            this.cc = cc;
            return this;
        }

        public Builder bcc(List<String> bcc) {
            this.bcc = bcc;
            return this;
        }

        public Builder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder attachments(List<Attachment> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder tags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public Builder scheduledAt(String scheduledAt) {
            this.scheduledAt = scheduledAt;
            return this;
        }

        public CreateEmailOptions build() {
            CreateEmailOptions options = new CreateEmailOptions();
            options.from = this.from;
            options.to = this.to;
            options.subject = this.subject;
            options.html = this.html;
            options.text = this.text;
            options.cc = this.cc;
            options.bcc = this.bcc;
            options.replyTo = this.replyTo;
            options.headers = this.headers;
            options.attachments = this.attachments;
            options.tags = this.tags;
            options.scheduledAt = this.scheduledAt;
            return options;
        }
    }

    public String getFrom() { return from; }
    public List<String> getTo() { return to; }
    public String getSubject() { return subject; }
    public String getHtml() { return html; }
    public String getText() { return text; }
    public List<String> getCc() { return cc; }
    public List<String> getBcc() { return bcc; }
    public String getReplyTo() { return replyTo; }
    public Map<String, String> getHeaders() { return headers; }
    public List<Attachment> getAttachments() { return attachments; }
    public List<Tag> getTags() { return tags; }
    public String getScheduledAt() { return scheduledAt; }
}
