package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class KPIDetailsPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("KPIs Details");
    }

    private By tab(String tabId) {
        return By.id("pills-" + tabId + "-tab");
    }

    public void clickTab(String tabId) {

        jsClick(tab(tabId));

        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void openAllTabs() {

        clickTab("KPIsCycles");
        clickTab("POA");
        clickTab("AdvancedInitiatives");
        clickTab("Projects");
        clickTab("Stakeholders");
        clickTab("ExecutiveReports");
        clickTab("Issues");
        clickTab("Risks");
        clickTab("BasicActions");
        clickTab("AuditActions");
        clickTab("AuditCorrection");
        clickTab("AuditRisks");
        clickTab("CommunicationCenter");
        clickTab("ModificationLogs");
    }
}