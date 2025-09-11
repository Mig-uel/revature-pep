package com.example;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info(String.format("Example log message from %s", Main.class.getSimpleName()));
    }
}