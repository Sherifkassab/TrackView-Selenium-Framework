package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class KPIHubPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    private final By chkShowAllStrategies = By.id("chkAll");

    private final By ddlKPINature =
            By.cssSelector("select[id^='kpinaturelstDrpdown']");

    private final By btnNextPage =
            By.xpath("//a[@aria-label='Next']");

    private final By lblCurrentPage =
            By.xpath("//span[contains(@class,'pagination-page-link')]");

    private By kpiNameLocator(String kpiName) {
        return By.xpath(
                "//td[@data-label='KPI']//span[@title='" + kpiName + "']"
        );
    }

    public boolean isPageDisplayed() {
        return isDisplayed(lblPageTitle);
    }

    public String getPageTitle() {
        return getText(lblPageTitle);
    }

    public boolean isPageTitleCorrect() {
        return getPageTitle().equals("KPIs Hub");
    }

    public void refreshKPIs() {

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

    public void showAllStrategies() {

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(chkShowAllStrategies)
        );

        if (!checkbox.isSelected()) {

            checkbox.click();

            waitSpinnerDisappear();
            waitPageLoad();
        }
    }

    public void hideAllStrategies() {

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(chkShowAllStrategies)
        );

        if (checkbox.isSelected()) {

            checkbox.click();

            waitSpinnerDisappear();
            waitPageLoad();
        }
    }

    public void selectAllNature() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(ddlKPINature)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText("All");

        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void selectOperationalNature() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(ddlKPINature)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText("Operational");

        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void selectStrategicNature() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(ddlKPINature)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText("Strategic");

        waitSpinnerDisappear();
        waitPageLoad();
    }

    public boolean isKPIExists(String kpiName) {

        try {
            return byToWeb(kpiNameLocator(kpiName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openKPI(String kpiName) {

        By locator = By.xpath(
                "//td[@data-label='KPI']//a[.//span[@title='" + kpiName + "']]"
        );

        WebElement kpi = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        kpi.click();

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

    public void openKPIFromAllPages(String kpiName) {

        while (true) {

            if (isKPIExists(kpiName)) {

                openKPI(kpiName);
                return;
            }

            int currentPage = getCurrentPage();

            clickNextPage();

            if (currentPage == getCurrentPage()) {

                throw new RuntimeException(
                        "KPI '" + kpiName + "' was not found."
                );
            }
        }
    }
}