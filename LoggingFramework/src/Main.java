import appenders.ConsoleAppender;
import enums.LogLevel;
import formatter.Formatter;
import formatter.StringFormatter;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.DEBUG);
        Formatter formatter = new StringFormatter();
        ConsoleAppender consoleAppender = new ConsoleAppender(formatter);
        logger.addAppener(consoleAppender);
        logger.log(LogLevel.ERROR,"404 not found");
    }
}