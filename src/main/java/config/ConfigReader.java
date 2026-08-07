package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (FileInputStream file = new FileInputStream("src/main/resources/config.properties");
             InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8)) {

            properties.load(reader);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public static String getUsername() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getStrategyName() {
        return getProperty("strategyName");
    }
    public static String getObjectiveName() {
        return getProperty("objectiveName");
    }
    public static String getKPIName() {
        return getProperty("kpiName");
    }

    public static String getRelease() {
        return getProperty("release");
    }

    public static String getEnvironment() {
        return getProperty("environment");
    }

    public static String getTester() {
        return getProperty("tester");
    }

    public static String getSystem() {
        return getProperty("system");
    }
}
