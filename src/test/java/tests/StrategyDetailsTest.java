package tests;

import base.BaseTest;
import components.LeftMenu;
import config.ConfigReader;
import org.testng.annotations.Test;
import pages.StrategyDetailsPage;

public class StrategyDetailsTest extends BaseTest {

    @Test
    public void testStrategyDetailsTabs() {

        LeftMenu leftMenu = new LeftMenu();
        StrategyDetailsPage strategyDetailsPage = new StrategyDetailsPage();

        loginPage.open();
        loginPage.login();

        // Strategy Hub
        leftMenu.expandStrategy();
        leftMenu.clickStrategyHub();

        strategyHubPage.selectDefaultStrategy(
                ConfigReader.getStrategyName()
        );

        strategyHubPage.openStrategyFromAllPages(
                ConfigReader.getStrategyName()
        );

        // Strategy Details
        if (!strategyDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Details page is not displayed.");
        }

        strategyDetailsPage.openAllTabs();

    }
}