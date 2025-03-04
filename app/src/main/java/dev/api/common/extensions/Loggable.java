package dev.api.common.extensions;

import dev.api.application.config.MessageConfig;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {

    @Inject
    MessageConfig messageConfig = null;

    default Logger log() {
        return LoggerFactory.getLogger(this.getClass());
    }

    default String getMessage(String code, Object... params) {
        return messageConfig != null ? messageConfig.getMessage(code, params) : code;
    }

    default void info(String code, Object... params) {
        log().info(getMessage(code, params));
    }

    default void warn(String code, Object... params) {
        log().warn(getMessage(code, params));
    }

    default void error(String code, Object... params) {
        log().error(getMessage(code, params));
    }
}
