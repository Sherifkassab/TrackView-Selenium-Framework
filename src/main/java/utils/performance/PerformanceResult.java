package utils.performance;

public class PerformanceResult {

    private final String module;
    private final String page;
    private final long loadTime;
    private final long threshold;
    private final String status;

    public PerformanceResult(String module,
                             String page,
                             long loadTime,
                             long threshold,
                             String status) {

        this.module = module;
        this.page = page;
        this.loadTime = loadTime;
        this.threshold = threshold;
        this.status = status;
    }

    public String getModule() {
        return module;
    }

    public String getPage() {
        return page;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public long getThreshold() {
        return threshold;
    }

    public String getStatus() {
        return status;
    }
}