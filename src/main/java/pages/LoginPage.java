package pages;

import base.BasePage;
import config.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By txtUserName = By.id("Username");
    private final By txtPassword = By.id("Password");
    private final By btnLogin = By.id("login-submit");

    public void open() {
        setUrl(ConfigReader.getBaseUrl());
    }

    public void enterUserName(String userName) {
        type(txtUserName, userName);
    }

    public void enterPassword(String password) {
        type(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void login() {
        enterUserName(ConfigReader.getUsername());
        enterPassword(ConfigReader.getPassword());
        clickLogin();
    }
}