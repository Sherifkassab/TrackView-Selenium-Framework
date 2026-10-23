
package tests;

import base.BaseTest;
import components.LeftMenu;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StrategyHubPage;

public class CISmokeTest extends BaseTest {

    @Test
    public void loginAndOpenStrategyHub() {

        LoginPage loginPage = new LoginPage();
        LeftMenu leftMenu = new LeftMenu();
        StrategyHubPage strategyHubPage = new StrategyHubPage();

        // Login
        loginPage.open();
        loginPage.login();

        // Open Strategy Hub
        leftMenu.expandStrategy();
        leftMenu.clickStrategyHub();

        // Verify page
        if (!strategyHubPage.isPageDisplayed()) {
            throw new AssertionError("Strategy Hub page is not displayed.");
        }

        if (!strategyHubPage.isPageTitleCorrect()) {
            throw new AssertionError("Strategy Hub page title is incorrect.");
        }
    }
}
