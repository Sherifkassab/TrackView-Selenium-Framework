package tests;

import base.BaseTest;
import flows.EndToEndFlow;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {

        EndToEndFlow endToEndFlow = new EndToEndFlow();

        new EndToEndFlow().execute();    }
}