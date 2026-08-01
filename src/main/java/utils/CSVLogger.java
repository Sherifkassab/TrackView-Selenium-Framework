package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVLogger {

    private static final String FILE_PATH =
            System.getProperty("user.dir") + "/testResults.csv";

    public static void logResult(String testCase,
                                 String location,
                                 double executionTime) {

        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);

            // Write header only if needed
            if (new File(FILE_PATH).length() == 0) {
                writer.append("TestCase,Location,ExecutionTime\n");
            }

            writer.append(testCase)
                    .append(",")
                    .append(location)
                    .append(",")
                    .append(Double.toString(executionTime))
                    .append("\n");

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearCSV() {

        try {
            File file = new File(FILE_PATH);

            if (file.exists()) {

                // Opens file in overwrite mode and clears content
                FileWriter writer = new FileWriter(file, false);
                writer.write("");
                writer.close();

                System.out.println("CSV file cleared");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}