package components;

import base.BasePage;
import org.openqa.selenium.WebElement;

public class ToolBar extends BasePage {
    final static private String strategyXpath="//a/p/i[@title='Strategy']";
    final static private String ObjectiveHubXpath="//div/div/ul/li[1]/ul/li[2]";
    final static private String strategyHubXpath="//div/div/ul/li[1]/ul/li[1]";
    final static private String StrategyBaseXpath="//div/table[contains(@class,'strategy-grid') and not(contains(@style,'display:none'))]/tbody/tr";

    public static void clickOnStrategy()
    {
        WebElement strategyButton = getElement(strategyXpath);
        strategyButton.click();
        waitElementToBeVisible(strategyHubXpath);
    }
    public static void clickOnStrategyHub()
    {

        WebElement strategyHubButton = getElement(strategyHubXpath);
        strategyHubButton.click();
        waitElementToBeClickable(StrategyBaseXpath);
    }
    public static void clickOnObjectiveHub()
    {

        WebElement objectiveHubButton = getElement(ObjectiveHubXpath);
        objectiveHubButton.click();
        waitPageLoad();
    }
}
