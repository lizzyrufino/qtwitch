package dev.api.application.config;

import jakarta.enterprise.context.ApplicationScoped;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@ApplicationScoped
public class MessageConfig {

    private static final String BUNDLE_NAME = "message";

    public String getMessage(String key, Object... params) {
        var bundle = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());
        var message = bundle.getString(key);
        return MessageFormat.format(message, params);
    }
}
