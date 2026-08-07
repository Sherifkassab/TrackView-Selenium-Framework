package flows;

import components.LeftMenu;
import config.ConfigReader;
import pages.*;
import utils.performance.ExcelReport;
import utils.performance.PerformanceTracker;

public class PerformanceFlow {

    private final LoginPage loginPage = new LoginPage();

    private final LeftMenu leftMenu = new LeftMenu();

    private final StrategyHubPage strategyHubPage =
            new StrategyHubPage();

    private final StrategyDetailsPage strategyDetailsPage =
            new StrategyDetailsPage();

    private final ObjectiveHubPage objectiveHubPage =
            new ObjectiveHubPage();

    private final ObjectiveDetailsPage objectiveDetailsPage =
            new ObjectiveDetailsPage();

    private void measureObjectiveTab(String tabName) {

        performance.start();
        objectiveDetailsPage.clickTab(tabName);
        performance.stop("Objective", tabName);
    }

    private final KPIHubPage kpiHubPage =
            new KPIHubPage();

    private final KPIDetailsPage kpiDetailsPage =
            new KPIDetailsPage();

    private void measureKPITab(String tabName) {

        performance.start();
        kpiDetailsPage.clickTab(tabName);
        performance.stop("KPI", tabName);
    }

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
        // Objective Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickObjectiveHub();
        performance.stop("Objective", "Objective Hub");

        if (!objectiveHubPage.isPageDisplayed()) {
            throw new RuntimeException("Objective Hub page is not displayed.");
        }
        if (!objectiveHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("Objective Hub page title is incorrect.");
        }

        objectiveHubPage.refreshObjectives();

        // =========================
        // Objective Details
        // =========================

        performance.start();

        objectiveHubPage.openObjectiveFromAllPages(
                ConfigReader.getObjectiveName()
        );

        performance.stop("Objective", "Objective Details");
        if (!objectiveDetailsPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Objective Details page is not displayed."
            );
        }
        if (!objectiveDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Objective Details page title is incorrect."
            );
        }

        // =========================
        // Objective Tabs
        // =========================

        measureObjectiveTab("ObjectivesCycles");
        measureObjectiveTab("SubObjectives");
        measureObjectiveTab("KPIs");
        measureObjectiveTab("OperationalKPIs");
        measureObjectiveTab("OKRs");
        measureObjectiveTab("AdvancedInitiatives");
        measureObjectiveTab("Projects");
        measureObjectiveTab("RelatedStrategies");
        measureObjectiveTab("Stakeholders");
        measureObjectiveTab("ExecutiveReports");
        measureObjectiveTab("Issues");
        measureObjectiveTab("Risks");
        measureObjectiveTab("BasicActions");
        measureObjectiveTab("AuditActions");
        measureObjectiveTab("AuditCorrection");
        measureObjectiveTab("AuditRisks");
        measureObjectiveTab("CommunicationCenter");
        measureObjectiveTab("ModificationLogs");
        measureObjectiveTab("ContributingEntitites");
        measureObjectiveTab("ParticipatingEntities");

        // =========================
        // KPI Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickKPIHub();
        performance.stop("KPI", "KPI Hub");

        if (!kpiHubPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "KPI Hub page is not displayed."
            );
        }
        if (!kpiHubPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "KPI Hub page title is incorrect."
            );
        }
        kpiHubPage.refreshKPIs();

        // =========================
        // KPI Details
        // =========================

        performance.start();
        kpiHubPage.openKPIFromAllPages(
                ConfigReader.getKPIName()
        );
        performance.stop("KPI", "KPI Details");

        if (!kpiDetailsPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "KPI Details page is not displayed."
            );
        }
        if (!kpiDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "KPI Details page title is incorrect."
            );
        }

        // =========================
        // KPI Tabs
        // =========================

        measureKPITab("KPIsCycles");
        measureKPITab("POA");
        measureKPITab("AdvancedInitiatives");
        measureKPITab("Projects");
        measureKPITab("Stakeholders");
        measureKPITab("ExecutiveReports");
        measureKPITab("Issues");
        measureKPITab("Risks");
        measureKPITab("BasicActions");
        measureKPITab("AuditActions");
        measureKPITab("AuditCorrection");
        measureKPITab("AuditRisks");
        measureKPITab("CommunicationCenter");
        measureKPITab("ModificationLogs");

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