package flows;

import components.LeftMenu;
import config.ConfigReader;
import pages.LoginPage;
import pages.StrategyDetailsPage;
import pages.StrategyHubPage;
import utils.performance.ExcelReport;
import utils.performance.PerformanceTracker;

public class PerformanceFlow {

    private final LoginPage loginPage = new LoginPage();

    private final LeftMenu leftMenu = new LeftMenu();

    private final StrategyHubPage strategyHubPage =
            new StrategyHubPage();

    private final StrategyDetailsPage strategyDetailsPage =
            new StrategyDetailsPage();

    private final PerformanceTracker performance =
            new PerformanceTracker();

    public void execute() {

        // =========================
        // Login
        // =========================

        loginPage.open();

        performance.start();
        loginPage.login();
        performance.stop("Login", "Login");

        // =========================
        // Strategy Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickStrategyHub();
        performance.stop("Strategy", "Strategy Hub");

        if (!strategyHubPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Hub page is not displayed.");
        }

        strategyHubPage.selectDefaultStrategy(
                ConfigReader.getStrategyName()
        );

        // =========================
        // Strategy Details
        // =========================

        if (!strategyHubPage.moveToStrategyPage(
                ConfigReader.getStrategyName()
        )) {

            throw new RuntimeException(
                    "Strategy '" + ConfigReader.getStrategyName() + "' was not found."
            );
        }

        performance.start();

        strategyHubPage.openStrategyOnly(
                ConfigReader.getStrategyName()
        );

        performance.stop("Strategy", "Strategy Details");

        // =========================
        // Strategy Tabs
        // =========================

        measureTab("Objectives");
        measureTab("KPIs");
        measureTab("OperationalKPIs");
        measureTab("OKRs");
        measureTab("StrategiesCycles");
        measureTab("Initiatives");
        measureTab("Projects");
        measureTab("RelatedStrategies");
        measureTab("Stakeholders");
        measureTab("ExecutiveReports");
        measureTab("Issues");
        measureTab("Actions");
        measureTab("CommunicationCenter");
        measureTab("ModificationLogs");
        measureTab("BSCPerspectives");

        // =========================
        // Excel Report
        // =========================

        new ExcelReport().generate(
                performance.getResults()
        );
    }

    private void measureTab(String tabName) {

        performance.start();

        strategyDetailsPage.clickTab(tabName);

        performance.stop("Strategy", tabName);
    }
}