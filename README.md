# Mailifica Java SDK (`mailifica-java`)

> SDK oficial em Java para a plataforma de e-mails transacionais **Mailifica**, com interface drop-in replacement compatível com o Resend Java SDK.

---

## 📦 Instalação

### Maven (`pom.xml`)
```xml
<dependency>
    <groupId>com.mailifica</groupId>
    <artifactId>mailifica-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle (`build.gradle`)
```groovy
implementation 'com.mailifica:mailifica-java:1.0.0'
```

---

## 🚀 Como Usar

### 1. Enviar E-mail Transacional

```java
import com.mailifica.Mailifica;
import com.mailifica.services.emails.model.CreateEmailOptions;
import com.mailifica.services.emails.model.CreateEmailResponse;

public class App {
    public static void main(String[] args) {
        Mailifica mailifica = new Mailifica("ma_live_123456789");

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@suaempresa.ao")
                .to("destinatario@exemplo.com")
                .subject("Boas-vindas ao Mailifica!")
                .html("<h1>Conta Ativada</h1><p>Seu acesso foi liberado com sucesso.</p>")
                .build();

        CreateEmailResponse response = mailifica.emails().send(params);
        System.out.println("E-mail enviado! ID: " + response.getId());
    }
}
```

### 2. Envio em Lote (Batch)

```java
List<CreateEmailOptions> batch = List.of(
    CreateEmailOptions.builder().from("news@suaempresa.ao").to("user1@gmail.com").subject("Novidade").html("<p>Oi 1</p>").build(),
    CreateEmailOptions.builder().from("news@suaempresa.ao").to("user2@gmail.com").subject("Novidade").html("<p>Oi 2</p>").build()
);

CreateBatchEmailsResponse resp = mailifica.batch().send(batch);
```

### 3. Gestão de Domínios e API Keys

```java
Domain domain = mailifica.domains().create("suaempresa.ao");
Domain verified = mailifica.domains().verify(domain.getId());

List<ApiKey> keys = mailifica.apiKeys().list();
```

---

## 📄 Licença

MIT © [Mailifica](https://mailifica.com)
