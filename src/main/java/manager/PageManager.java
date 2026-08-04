package manager;

import components.LeftMenu;
import pages.LoginPage;

import pages.StrategyHubPage;

public class PageManager {

    private LoginPage loginPage;
    private StrategyHubPage strategyHubPage;

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


    public LeftMenu getLeftMenu() {
        if (leftMenu == null) {
            leftMenu = new LeftMenu();
        }
        return leftMenu;
    }
}