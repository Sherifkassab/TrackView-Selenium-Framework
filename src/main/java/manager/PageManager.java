package manager;

import components.LeftMenu;
import pages.LoginPage;
import pages.ObjectiveDetailsPage;
import pages.ObjectiveHubPage;
import pages.StrategyHubPage;

public class PageManager {

    private LoginPage loginPage;
    private StrategyHubPage strategyHubPage;
    private ObjectiveHubPage objectiveHubPage;
    private ObjectiveDetailsPage objectiveDetailsPage;
    private LeftMenu leftMenu;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public StrategyHubPage getStrategyHubPage() {
        if (strategyHubPage == null) {
            strategyHubPage = new StrategyHubPage();
        }
        return strategyHubPage;
    }

    public ObjectiveHubPage getObjectiveHubPage() {
        if (objectiveHubPage == null) {
            objectiveHubPage = new ObjectiveHubPage();
        }
        return objectiveHubPage;
    }

    public ObjectiveDetailsPage getObjectiveDetailsPage() {
        if (objectiveDetailsPage == null) {
            objectiveDetailsPage = new ObjectiveDetailsPage();
        }
        return objectiveDetailsPage;
    }

    public LeftMenu getLeftMenu() {
        if (leftMenu == null) {
            leftMenu = new LeftMenu();
        }
        return leftMenu;
    }
}