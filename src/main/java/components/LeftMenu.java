package components;

import base.BasePage;
import org.openqa.selenium.By;

public class LeftMenu extends BasePage {

    private final By strategyIcon = By.xpath("//i[@title='Strategy']");
    private final By strategyHub = By.xpath("//span[normalize-space()='Strategy Hub']");

    public void expandStrategy() {
        click(strategyIcon);
    }

    public void clickStrategyHub() {
        click(strategyHub);
        waitPageLoad();
    }
}