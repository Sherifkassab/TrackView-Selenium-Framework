package base;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        driver = DriverFactory.getDriver();
        if (driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }

    public static void refreshDriver() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static WebElement byToWeb(By loc) {
        return driver.findElement(loc);
    }

    public static void setUrl(String url) {
        driver.get(url);
    }

    public static WebElement getElement(String elementXpath) {
        return byToWeb(By.xpath(elementXpath));
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
        element.click();
    }

    protected String getText(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        return element.getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitPageLoad() {
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    public static void waitElementToBeClickable(String element) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    public static void waitElementToBeVisible(String element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public static void goBack() {
        driver.navigate().back();
    }
}