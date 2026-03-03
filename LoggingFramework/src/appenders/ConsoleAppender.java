package appenders;

import entity.LogMessage;
import formatter.Formatter;

public class ConsoleAppender extends Appender{
    public ConsoleAppender(Formatter formatter){
        super(formatter);
    }
    @Override
    public void append(LogMessage logMessage) {
        Object message = formatter.format(logMessage);
        System.out.println(message);
    }

    @Override
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }
}
