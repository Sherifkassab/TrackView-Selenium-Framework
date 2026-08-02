package components;

import base.BasePage;
import org.openqa.selenium.By;

public class LeftMenu extends BasePage {

    private final By strategyIcon = By.xpath("//i[@title='Strategy']");

    private final By strategyHub =
            By.xpath("//span[normalize-space()='Strategy Hub']");

    private final By objectiveHub =
            By.xpath("//span[normalize-space()='Objective Hub']");

    private final By kpiHub =
            By.xpath("//span[normalize-space()='KPI Hub']");

    private final By objectivesCyclesWeights =
            By.xpath("//span[contains(normalize-space(),'Objectives Cycles Weights')]");

    private final By kpisCyclesWeights =
            By.xpath("//span[contains(normalize-space(),'KPIs Cycles Weights')]");

    private final By kpisPendingApprovalHub =
            By.xpath("//span[contains(normalize-space(),'KPIs Hub(Pending for Approval)')]");

    private final By strategyDashboard =
            By.xpath("//span[contains(normalize-space(),'Strategy Dashboard')]");

    private final By strategyRadar =
            By.xpath("//span[contains(normalize-space(),'Strategy Radar')]");

    private final By bscMapHub =
            By.xpath("//span[contains(normalize-space(),'BSC Map Hub')]");

    private final By bscPerspectivesHub =
            By.xpath("//span[contains(normalize-space(),'BSC Perspectives Hub')]");

    private final By bscDashboard =
            By.xpath("//span[normalize-space()='BSC Dashboard']");

    private final By bscAccordion =
            By.xpath("//span[normalize-space()='BSC Accordion']");

    private final By bscExecutiveSummary =
            By.xpath("//span[normalize-space()='BSC Executive Summary']");

    private final By risksDashboard =
            By.xpath("//span[normalize-space()='Risks Dashboard']");

    public void expandStrategy() {
        click(strategyIcon);
    }

    public void clickStrategyHub() {
        click(strategyHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickObjectiveHub() {
        click(objectiveHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickKPIHub() {
        click(kpiHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickObjectivesCyclesWeights() {
        jsClick(objectivesCyclesWeights);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickKPIsCyclesWeights() {
        jsClick(kpisCyclesWeights);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickKPIsPendingApprovalHub() {
        jsClick(kpisPendingApprovalHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickStrategyDashboard() {
        jsClick(strategyDashboard);
        waitSpinnerDisappear();
        waitPageLoad();

    }
    public void clickStrategyRadar() {
        jsClick(strategyRadar);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickBSCMapHub() {
        jsClick(bscMapHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }

    public void clickBSCPerspectivesHub() {
        jsClick(bscPerspectivesHub);
        waitSpinnerDisappear();
        waitPageLoad();
    }
    public void clickBSCDashboard() {
        jsClick(bscDashboard);
        waitSpinnerDisappear();
        waitPageLoad();
    }
    public void clickBSCAccordion() {

        jsClick(bscAccordion);
        waitSpinnerDisappear();
        waitPageLoad();
    }
    public void clickBSCExecutiveSummary() {

        jsClick(bscExecutiveSummary);
        waitSpinnerDisappear();
        waitPageLoad();
    }
    public void clickRisksDashboard() {

        jsClick(risksDashboard);
        waitSpinnerDisappear();
        waitPageLoad();
    }
}