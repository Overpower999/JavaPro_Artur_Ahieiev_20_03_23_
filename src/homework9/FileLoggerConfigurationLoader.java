package homework9;

import java.io.*;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(File configuration) {
        //String[] lines = new String[4];

        String file = null;
        String formate = null;
        long maxFileSize = 100000;
        LogingLevel level = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(configuration)))) {
            String line = null;
            int lineIndex = 0;

            while ((line = reader.readLine()) != null) {

                String[] lineParts = line.split(":");

                String value = lineParts[1].trim();

                switch (lineParts[0]) {
                    case "FILE":
                        file = value;
                        break;
                    case "FORMAT":
                        formate = value;
                        break;
                    case "MAX-SIZE":
                        maxFileSize = Long.parseLong(value);
                        break;
                    case "LEVEL":
                        level = LogingLevel.valueOf(value);
                        break;
                }

            /*lines[lineIndex] = line.substring(line.indexOf(':') + 1);
            lineIndex++;*/
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file == null || formate == null || level == null) {
            throw new IllegalArgumentException("Invalide config");
        }
        return new FileLoggerConfiguration(
                new File(file),
                formate,
                maxFileSize,
                level
        );
    }
}
