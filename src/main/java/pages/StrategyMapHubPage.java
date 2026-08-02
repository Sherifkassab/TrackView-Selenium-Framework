package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StrategyMapHubPage extends BasePage {

    // Locators

    private final By lblPageTitle =
            By.id("HeaderPageTitle");

    private final By chkShowAllStrategies =
            By.id("chkAll");

    // Methods

    public boolean isPageDisplayed() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPageTitle));

        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPageTitle));

        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {

        return getPageTitle().equals("Strategy Map Hub");
    }

    public void showAllStrategies() {

        if (!byToWeb(chkShowAllStrategies).isSelected()) {
            click(chkShowAllStrategies);
            waitSpinnerDisappear();
        }
    }

    public void hideAllStrategies() {

        if (byToWeb(chkShowAllStrategies).isSelected()) {
            click(chkShowAllStrategies);
            waitSpinnerDisappear();
        }
    }
}