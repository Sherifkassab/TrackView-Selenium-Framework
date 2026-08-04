package utils.performance;

import base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTracker extends BasePage {

    private final List<PerformanceResult> results = new ArrayList<>();

    private long startTime;

    public void start() {

        startTime = System.nanoTime();
    }

    public void stop(String module, String page) {

        waitSpinnerDisappear();
        waitPageLoad();

        long endTime = System.nanoTime();

        long loadTime = (endTime - startTime) / 1_000_000;

        results.add(new PerformanceResult(
                module,
                page,
                loadTime,
                0,
                ""
        ));

        System.out.printf(
                "%-30s %6d ms%n",
                page,
                loadTime
        );
    }

    public List<PerformanceResult> getResults() {

        return results;
    }

    public void clear() {

        results.clear();
    }
}