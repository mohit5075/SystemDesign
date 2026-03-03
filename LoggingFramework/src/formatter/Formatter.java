package formatter;

import entity.LogMessage;

public interface Formatter {
    Object format(LogMessage logMessage);
}
