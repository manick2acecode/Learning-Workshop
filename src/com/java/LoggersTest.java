package com.java;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggersTest {

    private static final Logger LOGGER = LogManager.getLogger();

    private static String takesTimeToCompute(String param){
        LOGGER.trace("TRACE I will take time to compute {}", param);
        LOGGER.debug("DEBUG I will take time to compute {}", param);
        return "LOGGER_TEST";
    }

    public static void main(String[] args) {
        Configurator.setLevel("com.java", Level.DEBUG);
        // TRACE MODE PRINTS TRACE, DEBUG, INFO, WARN, ERROR, FATAL
        //LOGGER.trace("TRACE MODE {} ", takesTimeToCompute("without if loop"));




         LOGGER.trace(() -> takesTimeToCompute("without if loop"));
//        if(LOGGER.isTraceEnabled()) {
//            LOGGER.trace("TRACE MODE {} ", takesTimeToCompute("with if loop"));
//        }
        // DEBUG MODE PRINTS DEBUG, INFO, WARN, ERROR, FATAL
        LOGGER.debug("DEBUG MODE");
        // INFO MODE PRINTS INFO, WARN, ERROR, FATAL
        LOGGER.info("INFO MODE");
        // WARN MODE PRINTS WARN, ERROR, FATAL
        LOGGER.warn("WARN MODE");
        // ERROR MODE PRINTS ERROR, FATAL
        LOGGER.error("ERROR MODE");
        // FATAL MODE PRINTS FATAL
        LOGGER.fatal("FATAL MODE");

    }
}
