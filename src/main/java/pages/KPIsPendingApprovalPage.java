package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KPIsPendingApprovalPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    public boolean isPageDisplayed() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lblPageTitle)
        );

        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lblPageTitle)
        );

        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {

        return getPageTitle().equals("KPIs Pending for Approval Hub");
    }
}