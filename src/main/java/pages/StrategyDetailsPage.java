package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class StrategyDetailsPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("Strategy Details");
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

        clickTab("KPIs");
        clickTab("OperationalKPIs");
        clickTab("OKRs");
        clickTab("StrategiesCycles");
        clickTab("Initiatives");
        clickTab("Projects");
        clickTab("RelatedStrategies");
        clickTab("Stakeholders");
        clickTab("ExecutiveReports");
        clickTab("Issues");
        clickTab("Actions");
        clickTab("CommunicationCenter");
        clickTab("ModificationLogs");
        clickTab("BSCPerspectives");
    }
}