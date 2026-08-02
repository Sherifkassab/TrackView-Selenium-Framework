package tests;

import base.BaseTest;
import components.LeftMenu;
import config.ConfigReader;
import org.testng.annotations.Test;
import pages.KPIDetailsPage;
import pages.KPIHubPage;

public class KPIDetailsTest extends BaseTest {

    @Test
    public void testKPIDetailsTabs() {

        LeftMenu leftMenu = new LeftMenu();
        KPIHubPage kpiHubPage = new KPIHubPage();
        KPIDetailsPage kpiDetailsPage = new KPIDetailsPage();

        loginPage.open();
        loginPage.login();

        // =========================
        // Strategy Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickStrategyHub();

        strategyHubPage.selectDefaultStrategy(
                ConfigReader.getStrategyName()
        );

        // =========================
        // KPI Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickKPIHub();

        if (!kpiHubPage.isPageDisplayed()) {
            throw new RuntimeException("KPI Hub page is not displayed.");
        }

        if (!kpiHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("KPI Hub page title is incorrect.");
        }

        kpiHubPage.refreshKPIs();

        kpiHubPage.selectAllNature();

        kpiHubPage.selectOperationalNature();

        kpiHubPage.selectStrategicNature();

        kpiHubPage.openKPIFromAllPages(
                ConfigReader.getKPIName()
        );

        // =========================
        // KPI Details
        // =========================

        if (!kpiDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("KPI Details page is not displayed.");
        }

        if (!kpiDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException("KPI Details page title is incorrect.");
        }

        kpiDetailsPage.openAllTabs();
    }
}