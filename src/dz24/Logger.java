package dz24;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logs;

    private Logger() {
        logs = new ArrayList<>();
        System.out.println("Logger done");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logs.add(message);
        System.out.println("Log: " + message);
    }

    public void showLogs() {
        System.out.println("\nShow all logs:");
        for (String msg : logs) {
            System.out.println(msg);
        }
    }
}