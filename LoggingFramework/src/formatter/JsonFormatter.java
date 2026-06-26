package formatter;

import entity.LogMessage;

public class JsonFormatter implements Formatter{
    @Override
    public String format(LogMessage logMessage) {
        return String.format("""
                {
                 "timestamp": "%s",
                 "thread": "%s",
                 "level": "%s",
                 "message": "%s",
                }
                """,logMessage.getTimestamp(),logMessage.getThreadName(),logMessage.getLogLevel(),
                logMessage.getMessage());
    }
}
