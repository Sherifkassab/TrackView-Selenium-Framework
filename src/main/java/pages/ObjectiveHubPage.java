package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjectiveHubPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    private final By chkShowAllStrategies = By.id("chkAll");

    private final By btnNextPage =
            By.xpath("//a[@aria-label='Next']");

    private final By lblCurrentPage =
            By.xpath("//span[contains(@class,'pagination-page-link')]");

    private By objectiveNameLocator(String objectiveName) {
        return By.xpath(
                "//td[@data-label='Objective']//span[@title='" + objectiveName + "']"
        );
    }

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("Objectives Hub");
    }

    public void refreshObjectives() {

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(chkShowAllStrategies)
        );

        if (!checkbox.isSelected()) {
            checkbox.click();
            waitSpinnerDisappear();
            waitPageLoad();
        }

        if (checkbox.isSelected()) {
            checkbox.click();
            waitSpinnerDisappear();
            waitPageLoad();
        }
    }

    public boolean isObjectiveExists(String objectiveName) {

        try {
            return byToWeb(objectiveNameLocator(objectiveName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openObjective(String objectiveName) {

        By locator = By.xpath(
                "//td[@data-label='Objective']//a[.//span[@title='" + objectiveName + "']]"
        );

        WebElement objective = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        objective.click();

        waitPageLoad();
    }

    public void clickNextPage() {

        jsClick(btnNextPage);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public int getCurrentPage() {

        return Integer.parseInt(
                getText(lblCurrentPage).trim()
        );
    }

    public void openObjectiveFromAllPages(String objectiveName) {

        while (true) {

            if (isObjectiveExists(objectiveName)) {

                openObjective(objectiveName);
                return;
            }

            int currentPage = getCurrentPage();

            clickNextPage();

            if (currentPage == getCurrentPage()) {

                throw new RuntimeException(
                        "Objective '" + objectiveName + "' was not found."
                );
            }
        }
    }
}