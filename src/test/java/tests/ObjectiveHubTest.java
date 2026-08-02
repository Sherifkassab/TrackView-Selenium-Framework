package tests;

import base.BaseTest;
import components.LeftMenu;
import config.ConfigReader;
import org.testng.annotations.Test;
import pages.ObjectiveHubPage;

public class ObjectiveHubTest extends BaseTest {

    @Test
    public void testObjectivePagination() {

        LeftMenu leftMenu = new LeftMenu();
        ObjectiveHubPage objectiveHubPage = new ObjectiveHubPage();

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

        // Objective Hub
        leftMenu.expandStrategy();
        leftMenu.clickObjectiveHub();

        objectiveHubPage.refreshObjectives();

        objectiveHubPage.openObjectiveFromAllPages(
                ConfigReader.getObjectiveName()
        );
    }
}