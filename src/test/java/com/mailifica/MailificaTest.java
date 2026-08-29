package com.mailifica;

import com.mailifica.services.emails.model.CreateEmailOptions;
import com.mailifica.services.webhooks.Webhooks;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class MailificaTest {

    @Test
    public void testEmailOptionsBuilder() {
        CreateEmailOptions options = CreateEmailOptions.builder()
                .from("onboarding@empresa.ao")
                .to("cliente@gmail.com")
                .subject("Boas-vindas")
                .html("<p>Olá!</p>")
                .build();

        assertEquals("onboarding@empresa.ao", options.getFrom());
        assertTrue(options.getTo().contains("cliente@gmail.com"));
        assertEquals("Boas-vindas", options.getSubject());
        assertEquals("<p>Olá!</p>", options.getHtml());
    }

    @Test
    public void testWebhookVerification() throws Exception {
        String secret = "whsec_test_secret";
        String payload = "{\"id\":\"evt_123\",\"type\":\"email.delivered\"}";

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        String signature = hexString.toString();

        boolean isValid = Webhooks.verifySignature(payload, signature, secret);
        assertTrue(isValid);

        boolean isInvalid = Webhooks.verifySignature(payload, "bad_signature", secret);
        assertFalse(isInvalid);
    }
}
