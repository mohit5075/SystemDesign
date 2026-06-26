package formatter;

import entity.LogMessage;

public interface Formatter {
    String format(LogMessage logMessage);
}
