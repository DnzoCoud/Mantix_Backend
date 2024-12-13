package com.dnzocoud.mantix_api.infrastructure.adapters;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggableException {
    private final Logger logger;
    private final String module;
    private String uniqueId;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String SEPARATOR_LINE = "-----------------------------------------------";

    private static final AtomicLong sequence = new AtomicLong(0);
    private static final String HOST_NAME;

    static {
        String hostName;
        try {
            hostName = Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "unknow-host";
        }
        HOST_NAME = hostName;
    }

    private LoggableException(String module, Class<?> clazz) {
        this.module = module;
        this.logger = LoggerFactory.getLogger(clazz);
        this.uniqueId = generateUniqueId();
    }

    public static LoggableException getLogger(String module, Class<?> clazz) {
        return new LoggableException(module, clazz);
    }

    public String getUniqueId() {
        return uniqueId;
    }

    private String generateUniqueId() {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        long seq = sequence.getAndIncrement();
        return String.format("%s-%s-%s-%s-%d",
                module.toLowerCase(), // módulo
                HOST_NAME, // nombre del host
                timestamp, // timestamp
                UUID.randomUUID().toString().substring(0, 8), // UUID corto
                seq // secuencia
        );
    }

    private String formatException(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(SEPARATOR_LINE).append(LINE_SEPARATOR);
        sb.append("Exception Details:").append(LINE_SEPARATOR);
        sb.append("ID:").append(uniqueId).append(LINE_SEPARATOR);
        sb.append("Type: ").append(throwable.getClass().getName()).append(LINE_SEPARATOR);
        sb.append("Message: ").append(throwable.getMessage()).append(LINE_SEPARATOR);

        String stackTrace = Arrays.stream(throwable.getStackTrace()).map(StackTraceElement::toString)
                .collect(Collectors.joining(LINE_SEPARATOR + "\t"));

        sb.append("StackTrace: ").append(LINE_SEPARATOR).append("\t").append(stackTrace);

        if (throwable.getCause() != null) {
            sb.append(LINE_SEPARATOR).append("Cause By: ").append(LINE_SEPARATOR);
            sb.append(formatException(throwable.getCause()));
        }

        return sb.toString();
    }

    private String formatExceptionWithContext(String message, Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(SEPARATOR_LINE).append(LINE_SEPARATOR);
        sb.append("Module: ").append(module).append(LINE_SEPARATOR);
        sb.append("Context: ").append(message).append(LINE_SEPARATOR);
        sb.append(formatException(throwable));
        sb.append(SEPARATOR_LINE).append(LINE_SEPARATOR);

        return sb.toString();
    }

    public void info(String message, Throwable throwable) {
        try {
            this.uniqueId = generateUniqueId();
            MDC.put("module", module);
            MDC.put("uniqueId", this.uniqueId);
            logger.info(message);
        } finally {
            MDC.clear();
        }
    }

    public void error(String message, Throwable throwable) {
        try {
            this.uniqueId = generateUniqueId();
            MDC.put("module", module);
            MDC.put("uniqueId", this.uniqueId);

            logger.error(formatExceptionWithContext(message, throwable));
        } finally {
            MDC.clear();
        }
    }

    public void warn(String message, Throwable throwable) {
        try {
            this.uniqueId = generateUniqueId();
            MDC.put("module", module);
            MDC.put("uniqueId", this.uniqueId);

            logger.warn(formatExceptionWithContext(message, throwable));
        } finally {
            MDC.clear();
        }
    }
}
