import appenders.Appender;
import appenders.ConsoleAppender;
import appenders.FileAppender;
import enums.LogLevel;
import formatter.Formatter;
import formatter.JsonFormatter;
import formatter.StringFormatter;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.DEBUG);
        Formatter formatter = new StringFormatter();
        ConsoleAppender consoleAppender = new ConsoleAppender(formatter);
        logger.addAppener(consoleAppender);
        Appender appender = new FileAppender("application.log",
                new JsonFormatter());
        logger.addAppener(appender);
        logger.log(LogLevel.ERROR,"404 not found");
        logger.log(LogLevel.FATAL,"fatal error occurred");
        Runnable task = ()->{
            Logger.getInstance().log(LogLevel.FATAL,"fatal error");
            Logger.getInstance().log(LogLevel.ERROR,"error occurred");
        };
        Thread thread = new Thread(task,"demo-thread");
        thread.start();
    }
}