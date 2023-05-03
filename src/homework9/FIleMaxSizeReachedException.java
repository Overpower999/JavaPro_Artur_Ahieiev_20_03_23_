package homework9;

import java.io.File;

public class FIleMaxSizeReachedException extends RuntimeException {
    public FIleMaxSizeReachedException(File logFile) {
        super("Log file " + logFile + " max size reached");
    }
}
