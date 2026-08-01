package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StrategyHubPage extends BasePage {

    private final By lblPageTitle = By.id("HeaderPageTitle");

    private final By strategySelectionButton = By.id("dropdownMenuButton11");
    private final By strategySearchBox = By.id("strategiesValues-selectized");
    private final By applyButton = By.xpath("//button[normalize-space()='Apply']");

    private static final String strategyBaseXpath = "//span[@title='";
    private static final String strategyResultXpath =
            "//div[contains(@class,'option') and normalize-space()='%s']";

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

    public void selectDefaultStrategy(String strategyName) {

        click(strategySelectionButton);

        type(strategySearchBox, strategyName);

        WebElement strategy =
                getElement(String.format(strategyResultXpath, strategyName));

        strategy.click();

        click(applyButton);

        waitPageLoad();
    }

    public void openStrategy(String strategyName) {

        By locator = By.xpath(
                "//td[@data-label='Strategy Name']//a[.//span[@title='" + strategyName + "']]"
        );

        WebElement strategyLink = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        strategyLink.click();

        waitPageLoad();
    }
}