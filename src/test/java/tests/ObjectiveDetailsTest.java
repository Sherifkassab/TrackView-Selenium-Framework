package tests;

import base.BaseTest;
import components.LeftMenu;
import config.ConfigReader;
import org.testng.annotations.Test;
import pages.ObjectiveDetailsPage;
import pages.ObjectiveHubPage;

public class ObjectiveDetailsTest extends BaseTest {

    @Test
    public void testObjectiveDetailsTabs() {

        LeftMenu leftMenu = new LeftMenu();
        ObjectiveHubPage objectiveHubPage = new ObjectiveHubPage();
        ObjectiveDetailsPage objectiveDetailsPage = new ObjectiveDetailsPage();

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
        // Objective Hub
        // =========================

        leftMenu.expandStrategy();
        leftMenu.clickObjectiveHub();

        objectiveHubPage.refreshObjectives();

        objectiveHubPage.openObjectiveFromAllPages(
                ConfigReader.getObjectiveName()
        );

        // =========================
        // Objective Details
        // =========================

        if (!objectiveDetailsPage.isPageDisplayed()) {
            throw new RuntimeException("Objective Details page is not displayed.");
        }

        if (!objectiveDetailsPage.isPageTitleCorrect()) {
            throw new RuntimeException("Objective Details page title is incorrect.");
        }

        objectiveDetailsPage.openAllTabs();
    }
}