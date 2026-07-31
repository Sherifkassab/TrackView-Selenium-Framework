package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StrategyHubPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    private static final String strategyBaseXpath = "//span[@title='";

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("Strategies Hub");
    }

    public void clickOnStrategy(String name) {

        WebElement strategyElement = getElement(strategyBaseXpath + name + "']");
        strategyElement.click();
        waitPageLoad();
    }
}