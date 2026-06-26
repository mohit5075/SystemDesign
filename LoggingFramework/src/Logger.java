import appenders.Appender;
import entity.LogMessage;
import enums.LogLevel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Logger {
    private static Logger instance = null;
    private List<Appender> appenders = new ArrayList<>();
    private BlockingDeque<LogMessage> queue;
    private LogLevel currentLevel;
    private Logger(){
        queue = new LinkedBlockingDeque<>();
        Thread thread = new Thread(this::consume);
        thread.setDaemon(true);
        thread.start();
    }
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
        queue.add(logMessage);
    }
    private void consume() {
        while(true){
            try {
                LogMessage logMessage = queue.take();
                appenders.forEach(appender -> appender.append(logMessage));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
