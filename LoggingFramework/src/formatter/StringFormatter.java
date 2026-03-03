package formatter;

import entity.LogMessage;

public class StringFormatter implements Formatter{
    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s - %s: %s\n",
                logMessage.getTimestamp(),
                logMessage.getLogLevel(),
                logMessage.getMessage());
    }
}
