package tests;

import base.BaseTest;
import components.LeftMenu;
import config.ConfigReader;
import org.testng.annotations.Test;
import pages.KPIHubPage;

public class KPIHubTest extends BaseTest {

    @Test
    public void testKPIPagination() {

        LeftMenu leftMenu = new LeftMenu();
        KPIHubPage kpiHubPage = new KPIHubPage();

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

        // KPI Hub
        leftMenu.expandStrategy();
        leftMenu.clickKPIHub();

        kpiHubPage.showAllStrategies();
        kpiHubPage.hideAllStrategies();

        kpiHubPage.selectAllNature();
        kpiHubPage.selectOperationalNature();
        kpiHubPage.selectStrategicNature();

        kpiHubPage.openKPIFromAllPages(
                ConfigReader.getKPIName()
        );
    }
}