package tests;

import base.BaseTest;
import flows.PerformanceFlow;
import org.testng.annotations.Test;

public class PerformanceTest extends BaseTest {

    @Test
    public void strategyPerformanceTest() {

        new PerformanceFlow().execute();

    }
}