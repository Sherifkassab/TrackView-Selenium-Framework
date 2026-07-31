package base;

import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.StrategyHubPage;

public class BaseTest {

    protected LoginPage loginPage;
    protected StrategyHubPage strategyHubPage;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();
        BasePage.refreshDriver();

        loginPage = new LoginPage();
        strategyHubPage = new StrategyHubPage();
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.getDriver().quit();
    }
}