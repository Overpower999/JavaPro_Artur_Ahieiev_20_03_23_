package homework9;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private static final DateTimeFormatter DATE_TIME_FORMATER = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
    private final FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void info(String message) {
        log(LogingLevel.INFO, message);
    }

    public void debug(String message) {
        if (configuration.getLevel() != LogingLevel.DEBAG) {
            return;
        }
        log(LogingLevel.DEBAG, message);
    }

    private void log(LogingLevel logingLevel, String message) {

        String formatedDateTime = LocalDateTime.now().format(DATE_TIME_FORMATER);

        try {
            File logFile = configuration.getFile();

            if (logFile.length() >= configuration.getMaxSize()) {

                logFile.renameTo(new File(logFile.getCanonicalFile().getParentFile() + File.separator + "Log-" + formatedDateTime + ".txt"));

                //throw new FIleMaxSizeReachedException(logFile);
            }

            logFile.getCanonicalFile().getParentFile().mkdirs();

            if (!logFile.exists()) {
                logFile.createNewFile();

            }

            try (Writer writer = new OutputStreamWriter(new FileOutputStream(logFile, true))) {

                String messageForLogFile = configuration.getFormat();

                messageForLogFile = messageForLogFile.replace("[TIME]", formatedDateTime);
                messageForLogFile = messageForLogFile.replace("[LEVEL]", logingLevel.name());
                messageForLogFile = messageForLogFile.replace("[THREAD]", Thread.currentThread().getName());
                messageForLogFile = messageForLogFile.replace("[MESSAGE]", message);

                writer.append(messageForLogFile + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
