package homework9;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private String format;
    private long maxSize;
    private LogingLevel level;

    public FileLoggerConfiguration(File file, String format, long maxSize, LogingLevel level) {
        this.file = file;
        this.format = format;
        this.maxSize = maxSize;
        this.level = level;
    }

    public File getFile() {
        return file;
    }

    public String getFormat() {
        return format;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public LogingLevel getLevel() {
        return level;
    }
}
