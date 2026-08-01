package utils;

import base.BasePage;

public class NavigationUtils {
    public static void goBack(){
        BasePage.goBack();
        BasePage.waitPageLoad();
    }
}
