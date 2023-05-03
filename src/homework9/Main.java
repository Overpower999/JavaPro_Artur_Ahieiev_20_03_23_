package homework9;

import java.io.File;

public class Main {
    public static void main(String[] args) {


        FileLoggerConfiguration configuration = FileLoggerConfigurationLoader.load(new File("./logging-file.txt"));

        FileLogger fileLogger = new FileLogger(configuration);
        fileLogger.info("info message");
        fileLogger.debug("debug message");
    }
}
