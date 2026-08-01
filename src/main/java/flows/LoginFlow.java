package flows;

import components.LeftMenu;
import pages.LoginPage;
import pages.StrategyHubPage;

public class LoginFlow {

    private final LoginPage loginPage = new LoginPage();
    private final StrategyHubPage strategyHubPage = new StrategyHubPage();
    private final LeftMenu leftMenu = new LeftMenu();

    // اسم الاستراتيجية المستخدمة فى التست
    private static final String STRATEGY_NAME = "استراتيجية تقييم الجودة331";

    public void login() {

        loginPage.open();
        loginPage.login();

        leftMenu.expandStrategy();
        leftMenu.clickStrategyHub();

        if (!strategyHubPage.isPageDisplayed()) {
            throw new RuntimeException("Strategy Hub page is not displayed.");
        }

        if (!strategyHubPage.isPageTitleCorrect()) {
            throw new RuntimeException("Strategy Hub page title is incorrect.");
        }

        strategyHubPage.selectDefaultStrategy(STRATEGY_NAME);

        strategyHubPage.openStrategy(STRATEGY_NAME);
    }
}