package flows;

import components.LeftMenu;
import config.ConfigReader;
import pages.*;
import utils.performance.ExcelReport;
import utils.performance.PerformanceTracker;

public class PerformanceFlow {

    private final LoginPage loginPage = new LoginPage();
    private final LeftMenu leftMenu = new LeftMenu();

    private final StrategyHubPage strategyHubPage = new StrategyHubPage();
    private final StrategyDetailsPage strategyDetailsPage = new StrategyDetailsPage();

    private final ObjectiveHubPage objectiveHubPage = new ObjectiveHubPage();
    private final ObjectiveDetailsPage objectiveDetailsPage = new ObjectiveDetailsPage();
    private void measureObjectiveTab(String tabName) {

        performance.start();
        objectiveDetailsPage.clickTab(tabName);
        performance.stop("Objective", tabName);
    }

    private final KPIHubPage kpiHubPage = new KPIHubPage();
    private final KPIDetailsPage kpiDetailsPage = new KPIDetailsPage();
    private void measureKPITab(String tabName) {

        performance.start();
        kpiDetailsPage.clickTab(tabName);
        performance.stop("KPI", tabName);
    }

    private final ObjectivesCyclesWeightsPage objectivesCyclesWeightsPage = new ObjectivesCyclesWeightsPage();
    private final KPIsCyclesWeightsPage kpisCyclesWeightsPage = new KPIsCyclesWeightsPage();
    private final KPIsPendingApprovalPage kpisPendingApprovalPage = new KPIsPendingApprovalPage();
    private final StrategyDashboardPage strategyDashboardPage = new StrategyDashboardPage();
    private final StrategyPolarChartPage strategyPolarChartPage = new StrategyPolarChartPage();
    private final StrategyMapHubPage strategyMapHubPage = new StrategyMapHubPage();
    private final BSCPerspectivesHubPage bscPerspectivesHubPage = new BSCPerspectivesHubPage();
    private final BSCDashboardPage bscDashboardPage = new BSCDashboardPage();
    private final BSCAccordionPage bscAccordionPage = new BSCAccordionPage();
    private final BSCExecutiveSummaryPage bscExecutiveSummaryPage = new BSCExecutiveSummaryPage();
    private final RisksDashboardPage risksDashboardPage = new RisksDashboardPage();


    private final PerformanceTracker performance =
            new PerformanceTracker();

    public void execute() {

        // =========================
        // Login
        // =========================

        loginPage.open();

        performance.start();
        loginPage.login();
        performance.stop(
                         "Login",
                         "Login");

        // =========================
        // Strategy Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickStrategyHub();
        performance.stop(
                         "Strategy",
                         "Strategy Hub");

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
        performance.stop(
                         "Strategy",
                         "Strategy Details");

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
        performance.stop(
                         "Objective",
                         "Objective Hub");

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

        performance.stop(
                         "Objective",
                         "Objective Details");
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
        performance.stop(
                         "KPI",
                         "KPI Hub");

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
        performance.stop(
                         "KPI",
                         "KPI Details");

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
        // Objectives Cycles Weights
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickObjectivesCyclesWeights();
        performance.stop(
                         "Objectives Cycles Weights",
                         "Objectives Cycles Weights");

        if (!objectivesCyclesWeightsPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Objectives Cycles Weights page is not displayed."
            );
        }
        if (!objectivesCyclesWeightsPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Objectives Cycles Weights page title is incorrect."
            );
        }

        // =========================
        // KPIs Cycles Weights
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickKPIsCyclesWeights();
        performance.stop(
                         "KPIs Cycles Weights",
                         "KPIs Cycles Weights");

        if (!kpisCyclesWeightsPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "KPIs Cycles Weights page is not displayed."
            );
        }
        if (!kpisCyclesWeightsPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "KPIs Cycles Weights page title is incorrect."
            );
        }

        // =========================
        // KPIs Pending Approval
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickKPIsPendingApprovalHub();
        performance.stop(
                         "KPIs Pending Approval",
                         "KPIs Pending Approval"
        );

        if (!kpisPendingApprovalPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "KPIs Pending for Approval Hub page is not displayed."
            );
        }
        if (!kpisPendingApprovalPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "KPIs Pending for Approval Hub page title is incorrect."
            );
        }

        // =========================
        // Strategy Dashboard
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickStrategyDashboard();
        performance.stop(
                         "Strategy Dashboard",
                         "Strategy Dashboard");

        if (!strategyDashboardPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Strategy Dashboard page is not displayed."
            );
        }
        if (!strategyDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Strategy Dashboard page title is incorrect."
            );
        }

        // =========================
        // Strategy Radar
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickStrategyRadar();
        performance.stop(
                         "Strategy Radar",
                         "Strategy Radar");

        if (!strategyPolarChartPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Strategy Polar Chart page is not displayed."
            );
        }
        if (!strategyPolarChartPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Strategy Polar Chart page title is incorrect."
            );
        }

        // =========================
        // BSC Map Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickBSCMapHub();
        performance.stop(
                         "BSC Map Hub",
                         "BSC Map Hub");

        if (!strategyMapHubPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Strategy Map Hub page is not displayed."
            );
        }
        if (!strategyMapHubPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Strategy Map Hub page title is incorrect."
            );
        }

        // =========================
        // BSC Perspectives Hub
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickBSCPerspectivesHub();
        performance.stop(
                         "BSC Perspectives Hub",
                         "BSC Perspectives Hub");

        if (!bscPerspectivesHubPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "BSC Perspectives Hub page is not displayed."
            );
        }
        if (!bscPerspectivesHubPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "BSC Perspectives Hub page title is incorrect."
            );
        }

        // =========================
        // BSC Dashboard
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickBSCDashboard();
        performance.stop(
                         "BSC Dashboard",
                         "BSC Dashboard");

        if (!bscDashboardPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "BSC Dashboard page is not displayed."
            );
        }
        if (!bscDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "BSC Dashboard page title is incorrect."
            );
        }

        // =========================
        // BSC Accordion
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickBSCAccordion();
        performance.stop(
                         "BSC Accordion",
                         "BSC Accordion");

        if (!bscAccordionPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "BSC Accordion page is not displayed."
            );
        }
        if (!bscAccordionPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "BSC Accordion page title is incorrect."
            );
        }

        // =========================
        // BSC Executive Summary
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickBSCExecutiveSummary();

        performance.stop(
                         "BSC Executive Summary",
                         "BSC Executive Summary");

        if (!bscExecutiveSummaryPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "BSC Executive Summary page is not displayed."
            );
        }
        if (!bscExecutiveSummaryPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "BSC Executive Summary page title is incorrect."
            );
        }

        // =========================
        // Risks Dashboard
        // =========================

        leftMenu.expandStrategy();

        performance.start();
        leftMenu.clickRisksDashboard();
        performance.stop(
                         "Risks Dashboard",
                         "Risks Dashboard");

        if (!risksDashboardPage.isPageDisplayed()) {
            throw new RuntimeException(
                    "Risks Dashboard page is not displayed."
            );
        }
        if (!risksDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException(
                    "Risks Dashboard page title is incorrect."
            );
        }
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