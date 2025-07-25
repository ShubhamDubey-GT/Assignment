package org.assignment3;

import java.util.Date;
import java.text.SimpleDateFormat;

class Logger {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    void log(String message) {
        String time = sdf.format(new Date());
        System.out.println(time + ": " + message);
    }
    void logError(String err) {
        String time = sdf.format(new Date());
        System.out.println(time + " [ERROR]: " + err);
    }
}

public class Packages {
    public static void main(String[] args) {
        Logger log = new Logger();
        System.out.println("************************************");
        log.log("System started.");
        log.logError("File not found.");
        System.out.println("Using java.util package for Date formatting.");
        log.log("Another log entry.");
        System.out.println("Packages help organize code and import utilities.");
        System.out.println("************************************");
    }
}
