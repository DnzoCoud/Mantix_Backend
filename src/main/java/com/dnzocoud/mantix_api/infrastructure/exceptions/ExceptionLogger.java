package com.dnzocoud.mantix_api.infrastructure.exceptions;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLogger {
    public static String logException(String moduleName, Exception e) {
        Logger logger = LoggerFactory.getLogger(moduleName);

        String uniqueId = UUID.randomUUID().toString();

        logger.error("---------------------------------------------------------------------");
        logger.error("ID: {}", uniqueId);
        logger.error("Message: {}", e.getMessage());
        logger.error("Stack Trace: {}", e);
        logger.error("---------------------------------------------------------------------");

        return uniqueId;
    }

    public static <T> String logInfo(String moduleName, T e) {
        Logger logger = LoggerFactory.getLogger(moduleName);

        String uniqueId = UUID.randomUUID().toString();

        logger.info("---------------------------------------------------------------------");
        logger.info("ID: {}", uniqueId);
        logger.info("Message: {}", e);
        logger.info("---------------------------------------------------------------------");

        return uniqueId;
    }
}
