package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ObjectivesCyclesWeightsPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("Objectives Cycles Weights");
    }
}