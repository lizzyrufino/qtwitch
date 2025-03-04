package dev.api.application.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ApplicationProperties {

    @Inject
    @ConfigProperty(name = "security.crypt.cipher.key")
    public String cipherKey;
}
