package appenders;

import entity.LogMessage;
import formatter.Formatter;

public abstract class Appender {
    Formatter formatter;
    Appender(Formatter formatter){
        this.formatter = formatter;
    }
    public abstract void append(LogMessage logMessage);
}
