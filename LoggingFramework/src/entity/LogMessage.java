package entity;

import enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {
    private String message;
    private LogLevel logLevel;
    private LocalDateTime timestamp;
    public LogMessage(String message, LogLevel logLevel){
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
