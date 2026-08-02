package flows;

import components.LeftMenu;
import config.ConfigReader;
import pages.*;

public class EndToEndFlow {

    private final LoginPage loginPage = new LoginPage();

    private final StrategyHubPage strategyHubPage = new StrategyHubPage();

    private final ObjectiveHubPage objectiveHubPage = new ObjectiveHubPage();
    private final ObjectiveDetailsPage objectiveDetailsPage = new ObjectiveDetailsPage();

    private final KPIHubPage kpiHubPage = new KPIHubPage();
    private final KPIDetailsPage kpiDetailsPage = new KPIDetailsPage();

    private final ObjectivesCyclesWeightsPage objectivesCyclesWeightsPage =
            new ObjectivesCyclesWeightsPage();

    private final KPIsCyclesWeightsPage kpisCyclesWeightsPage =
            new KPIsCyclesWeightsPage();

    private final KPIsPendingApprovalPage kpisPendingApprovalPage =
            new KPIsPendingApprovalPage();

    private final StrategyDashboardPage strategyDashboardPage =
            new StrategyDashboardPage();

    private final StrategyPolarChartPage strategyPolarChartPage =
            new StrategyPolarChartPage();

    private final StrategyMapHubPage strategyMapHubPage =
            new StrategyMapHubPage();

    private final BSCPerspectivesHubPage bscPerspectivesHubPage =
            new BSCPerspectivesHubPage();

    private final BSCDashboardPage bscDashboardPage =
            new BSCDashboardPage();

    private final BSCAccordionPage bscAccordionPage =
            new BSCAccordionPage();

    private final BSCExecutiveSummaryPage bscExecutiveSummaryPage =
            new BSCExecutiveSummaryPage();

    private final RisksDashboardPage risksDashboardPage =
            new RisksDashboardPage();

    private final StrategyDetailsPage strategyDetailsPage =
            new StrategyDetailsPage();


    private final LeftMenu leftMenu = new LeftMenu();

    public void execute() {

        // =========================
        // Login
        // =========================

        loginPage.open();
        loginPage.login();

        // =========================
// Strategy Hub
// =========================

        leftMenu.expandStrategy();
        leftMenu.clickStrategyHub();

        if (!strategyHubPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Hub page is not displayed.");
        }

        if (!strategyHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Hub page title is incorrect.");
        }

        strategyHubPage.selectDefaultStrategy(ConfigReader.getStrategyName());

        strategyHubPage.openStrategyFromAllPages(ConfigReader.getStrategyName());

        // =========================
        // Strategy Details
        // =========================

        if (!strategyDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Details page is not displayed.");
        }

        if (!strategyDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Details page title is incorrect.");
        }

        strategyDetailsPage.openAllTabs();

        // =========================
// Objective Hub
// =========================

        leftMenu.expandStrategy();
        leftMenu.clickObjectiveHub();

        if (!objectiveHubPage.isPageDisplayed()) {
            throw new RuntimeException("Objective Hub page is not displayed.");
        }

        if (!objectiveHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("Objective Hub page title is incorrect.");
        }

        objectiveHubPage.refreshObjectives();

        objectiveHubPage.openObjectiveFromAllPages(
                ConfigReader.getObjectiveName()
        );

        if (!objectiveDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("Objective Details page is not displayed.");
        }

        if (!objectiveDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException("Objective Details page title is incorrect.");
        }

        objectiveDetailsPage.openAllTabs();

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

        kpiHubPage.showAllStrategies();
        kpiHubPage.hideAllStrategies();

        kpiHubPage.selectAllNature();
        kpiHubPage.selectOperationalNature();
        kpiHubPage.selectStrategicNature();

        kpiHubPage.openKPIFromAllPages(ConfigReader.getKPIName());

        if (!kpiDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("KPI Details page is not displayed.");
        }

        if (!kpiDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException("KPI Details page title is incorrect.");
        }

        kpiDetailsPage.openAllTabs();

        // =========================
        // Objectives Cycles Weights
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickObjectivesCyclesWeights();

        if (!objectivesCyclesWeightsPage.isPageDisplayed()) {
            throw new RuntimeException("Objectives Cycles Weights page is not displayed.");
        }

        if (!objectivesCyclesWeightsPage.isPageTitleCorrect()) {
            throw new RuntimeException("Objectives Cycles Weights page title is incorrect.");
        }

        // =========================
        // KPIs Cycles Weights
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickKPIsCyclesWeights();

        if (!kpisCyclesWeightsPage.isPageDisplayed()) {
            throw new RuntimeException("KPIs Cycles Weights page is not displayed.");
        }

        if (!kpisCyclesWeightsPage.isPageTitleCorrect()) {
            throw new RuntimeException("KPIs Cycles Weights page title is incorrect.");
        }

        // =========================
        // KPIs Pending for Approval Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickKPIsPendingApprovalHub();

        if (!kpisPendingApprovalPage.isPageDisplayed()) {
            throw new RuntimeException("KPIs Pending for Approval Hub page is not displayed.");
        }

        if (!kpisPendingApprovalPage.isPageTitleCorrect()) {
            throw new RuntimeException("KPIs Pending for Approval Hub page title is incorrect.");
        }
        // =========================
        // Strategy Dashboard
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickStrategyDashboard();

        if (!strategyDashboardPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Dashboard page is not displayed.");
        }

        if (!strategyDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Dashboard page title is incorrect.");
        }

        // =========================
        // Strategy Radar
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickStrategyRadar();

        if (!strategyPolarChartPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Polar Chart page is not displayed.");
        }

        if (!strategyPolarChartPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Polar Chart page title is incorrect.");
        }

        // =========================
        // BSC Map Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickBSCMapHub();

        if (!strategyMapHubPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Map Hub page is not displayed.");
        }

        if (!strategyMapHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Map Hub page title is incorrect.");
        }

        strategyMapHubPage.showAllStrategies();
        strategyMapHubPage.hideAllStrategies();

        // =========================
        // BSC Map Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickBSCPerspectivesHub();

        if (!bscPerspectivesHubPage.isPageDisplayed()) {
            throw new RuntimeException("BSC Perspectives Hub page is not displayed.");
        }

        if (!bscPerspectivesHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("BSC Perspectives Hub page title is incorrect.");
        }

        bscPerspectivesHubPage.showAllStrategies();
        bscPerspectivesHubPage.hideAllStrategies();

        // =========================
        // BSC Dashboard
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickBSCDashboard();

        if (!bscDashboardPage.isPageDisplayed()) {
            throw new RuntimeException("BSC Dashboard page is not displayed.");
        }

        if (!bscDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException("BSC Dashboard page title is incorrect.");

        }
        // =========================
        // BSC Accordion
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickBSCAccordion();

        if (!bscAccordionPage.isPageDisplayed()) {
            throw new RuntimeException("BSC Accordion page is not displayed.");
        }

        if (!bscAccordionPage.isPageTitleCorrect()) {
            throw new RuntimeException("BSC Accordion page title is incorrect.");
        }
        // =========================
        // BSC Executive Summary
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickBSCExecutiveSummary();

        if (!bscExecutiveSummaryPage.isPageDisplayed()) {
            throw new RuntimeException("BSC Executive Summary page is not displayed.");
        }

        if (!bscExecutiveSummaryPage.isPageTitleCorrect()) {
            throw new RuntimeException("BSC Executive Summary page title is incorrect.");
        }
        // =========================
        // Risks Dashboard
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickRisksDashboard();

        if (!risksDashboardPage.isPageDisplayed()) {
            throw new RuntimeException("Risks Dashboard page is not displayed.");
        }

        if (!risksDashboardPage.isPageTitleCorrect()) {
            throw new RuntimeException("Risks Dashboard page title is incorrect.");
        }
    }
}