package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BSCPerspectivesHubPage extends BasePage {

    private final By lblPageTitle =
            By.id("HeaderPageTitle");

    private final By chkShowAllStrategies =
            By.id("chkAll");

    public boolean isPageDisplayed() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPageTitle));

        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPageTitle));

        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {

        return getPageTitle().equals("BSC Perspectives Hub");
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