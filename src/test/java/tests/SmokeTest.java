package tests;

import base.BaseTest;
import flows.LoginFlow;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginFlow loginFlow = new LoginFlow();

        loginFlow.login();
    }
}