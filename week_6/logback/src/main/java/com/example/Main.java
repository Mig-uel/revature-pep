package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        logger.info("Hello, World!");
        logger.debug("This is a debug message.");
        logger.error("This is an error message.");
        logger.warn("This is a warning message.");
        logger.trace("This is a trace message.");

        /* Logging an exception */
        try {
            throw new RuntimeException("Test exception");
        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
        }
    }
}