package appenders;

import entity.LogMessage;
import formatter.Formatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender extends Appender{
    private final String fileName;
    public FileAppender(String fileName,Formatter formatter) {
        super(formatter);
        this.fileName = fileName;
    }

    @Override
    public void append(LogMessage logMessage) {
        try (FileWriter fileWriter = new FileWriter(fileName,true)){
            fileWriter.write(formatter.format(logMessage)+System.lineSeparator());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
