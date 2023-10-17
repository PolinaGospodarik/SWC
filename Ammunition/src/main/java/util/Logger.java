package main.java.util;

import org.apache.logging.log4j.LogManager;

public class Logger {
    static public org.apache.logging.log4j.Logger getLogg()
    {
        return LogManager.getLogger("Ammunition");
    }
}
