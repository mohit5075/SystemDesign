import appenders.Appender;
import entity.LogMessage;
import enums.LogLevel;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance = null;
    private List<Appender> appenders = new ArrayList<>();
    private LogLevel currentLevel;
    public static Logger getInstance(){
        if(instance==null){
            synchronized (Logger.class){
                if(instance==null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void addAppener(Appender appender){
        appenders.add(appender);
    }
    public void setLogLevel(LogLevel logLevel){
        this.currentLevel=logLevel;
    }
    public void log(LogLevel logLevel,String message){
        if(logLevel.ordinal()<currentLevel.ordinal())return;
        LogMessage logMessage = new LogMessage(message,logLevel);
        appenders.forEach(appender -> appender.append(logMessage));
    }
}
