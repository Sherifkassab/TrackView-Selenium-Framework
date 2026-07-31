package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported Browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}