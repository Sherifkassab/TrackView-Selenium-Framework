package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;

public class StrategyDetailsPage extends BasePage {
    final static private String ThreePointsXpath = "//i[contains(@class,'fa-ellipsis-vertica')]";
    final static private String objectiveBaseXpath = "//div/table/tbody/tr";
    final static private String elementLinkXpath = "/td/a";
    final static private String kpisXpath = "//*[@id=\"pills-KPIs-vertical-tab\"]";
    final static private String OkrsXpath = "//*[@id=\"pills-OKRs-vertical-tab\"]";
    final static private String InitiativesXpath = "//*[@id=\"pills-AdvancedInitiatives-vertical-tab\"]";
    final static private String StrategiesCyclesXpath = "//*[@id=\"pills-StrategiesCycles-vertical-tab\"]";
    final static private String ObjectivesCyclesXpath = "//*[@id=\"pills-ObjectivesCycles-vertical-tab\"]";
    final static private String ProjectsXpath = "//*[@id=\"pills-Projects-vertical-tab\"]";
    final static private String IssuesXpath = "//*[@id=\"pills-Issues-vertical-tab\"]";
    final static private String ActionsXpath = "//*[@id=\"pills-Actions-vertical-tab\"]";
    final static private String StakeholdersXpath = "//*[@id=\"pills-Stakeholders-vertical-tab\"]";
    final static private String OpisXpath ="//*[@id=\"pills-OperationalKPIs-vertical-tab\"]";
    final static private String ModificationsLogXpath = "//*[@id=\"pills-ModificationLogs-vertical-tab\"]";
    final static private String CommunicationCenterXpath = "//*[@id=\"pills-CommunicationCenter-vertical-tab\"]";
    final static private String ExecutiveReportsXpath = "//*[@id=\"pills-ExecutiveReports-vertical-tab\"]";
    final static private String ContributingEntititesXpath = "//*[@id=\"pills-ContributingEntitites-vertical-tab\"]";
    final static private String ParticipatingEntitiesXpath = "//*[@id=\"pills-ParticipatingEntities-vertical-tab\"]";
    final static private String RisksXpath = "//*[@id=\"pills-Risks-vertical-tab\"]";
    final static private String RelatedStrategiesXpath = "//*[@id=\"pills-RelatedStrategies-vertical-tab\"]";
    final static private String SubObjectivesXpath = "//*[@id=\"pills-SubObjectives-vertical-tab\"]";
    final static private String ObjectivesXpath = "//*[@id=\"pills-Objectives-vertical-tab\"]";
    final static private String kpiBaseXpath = "//table[contains(@class,'KPI-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String okrBaseXpath = "//table[contains(@class,'OKRs-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String initiativeBaseXpath = "//table[contains(@class,'advInitiative-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String StrategiesCycleBaseXpath = "//table[contains(@class,'objectives-cycles-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ObjectivesCycleBaseXpath = "//table[contains(@class,'objectives-cycles-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ProjectBaseXpath = "//table[contains(@class,'project-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String IssueBaseXpath = "//table[contains(@class,'on-mob') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ActionBaseXpath = "//table[contains(@class,'action-lookup-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String StakeholderBaseXpath = "//table[contains(@class,'stackholder-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String OpiBaseXpath ="//table[7]/tbody/tr";//  "/html/body/div[3]/div[3]/div/div/div[2]/main/div[5]/div[13]/div[2]/div[2]/table";
    final static private String ModificationsLogBaseXpath = "//table[contains(@class,'modificationLogs-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String CommunicationCenterBaseXpath = "//table[contains(@class,'communicationCenter-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ExecutiveReportsBaseXpath = "//table[contains(@class,'executive-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ContributingEntititesBaseXpath = "//table[contains(@class,'entity-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ParticipatingEntitiesBaseXpath = "//table[contains(@class,'ParticipatingEntity-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String RisksBaseXpath = "//table[contains(@class,'risks-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String RelatedStrategiesBaseXpath = "//table[contains(@class,'related-strategies') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String SubObjectivesBaseXpath = "//table[contains(@class,'objective-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    final static private String ObjectivesBaseXpath = "//table[contains(@class,'objective-grid') and not(contains(@style,'display:none'))]/tbody/tr";
    public static void clickOnObjective(int ind) {
        WebElement ObjectiveElement = getElement(objectiveBaseXpath + "[" + ind + "]" + elementLinkXpath);
        ObjectiveElement.click();
        waitPageLoad();
    }

    public static void clickOnKpiElement(int ind) {
        clickOnThreePoints();
        WebElement KpiElement = getElement(kpiBaseXpath + "[" + ind + "]" + elementLinkXpath);
        KpiElement.click();
        waitPageLoad();

    }

    public static void clickOnOkrElement(int ind) {
        clickOnThreePoints();
        WebElement OkrElement = getElement(okrBaseXpath + "[" + ind + "]" + elementLinkXpath);
        OkrElement.click();
        waitPageLoad();

    }

    public static void clickOnKpisTab() {
        clickOnThreePoints();
        WebElement KpiElement = getElement(kpisXpath);
        KpiElement.click();
        waitPageLoad();
        waitElementToBeClickable(kpiBaseXpath);

    }

    public static void clickOnOkrsTab() {
        clickOnThreePoints();
        WebElement OkrElement = getElement(OkrsXpath);
        OkrElement.click();
        waitElementToBeClickable(okrBaseXpath);
    }

    public static void clickOnInitiativesTab() {
        clickOnThreePoints();
        WebElement OkrElement = getElement(InitiativesXpath);
        OkrElement.click();
        waitElementToBeClickable(initiativeBaseXpath);

    }

    public static void clickOnObjectivesCyclesTab() {
        clickOnThreePoints();
        WebElement OkrElement = getElement(ObjectivesCyclesXpath);
        OkrElement.click();
        waitElementToBeClickable(ObjectivesCycleBaseXpath);
    }
    public static void clickOnStrategiesCyclesTab() {
        clickOnThreePoints();
        WebElement OkrElement = getElement(StrategiesCyclesXpath);
        OkrElement.click();
        waitElementToBeClickable(StrategiesCycleBaseXpath);
    }
    public static void clickOnProjectsTab() {
        clickOnThreePoints();
        WebElement OkrElement = getElement(ProjectsXpath);
        OkrElement.click();
        waitElementToBeClickable(ProjectBaseXpath);
    }

    public static void clickOnIssuesTab() {
        clickOnThreePoints();
        WebElement IssueElement = getElement(IssuesXpath);
        IssueElement.click();
        waitElementToBeClickable(IssueBaseXpath);
    }

    public static void clickOnActionsTab() {
        clickOnThreePoints();
        WebElement ActionElement = getElement(ActionsXpath);
        ActionElement.click();
        waitElementToBeClickable(ActionBaseXpath);
    }

    public static void clickOnStakeholdersTab() {
        clickOnThreePoints();
        WebElement Stakeholder = getElement(StakeholdersXpath);
        Stakeholder.click();
        waitElementToBeClickable(StakeholderBaseXpath);
    }
    public static void clickOnOpisTab() {
        clickOnThreePoints();
        WebElement Stakeholder = getElement(OpisXpath);
        Stakeholder.click();
        waitElementToBeClickable(OpiBaseXpath);
    }
    public static void clickOnModificationsLogTab() {
        clickOnThreePoints();
        WebElement Stakeholder = getElement(ModificationsLogXpath);
        Stakeholder.click();
        waitElementToBeClickable(ModificationsLogBaseXpath);
    }
    public static void clickOnCommunicationCenterTab() {
        clickOnThreePoints();
        WebElement Stakeholder = getElement(CommunicationCenterXpath);
        Stakeholder.click();
        waitElementToBeClickable(CommunicationCenterBaseXpath);
    }
    public static void clickOnExecutiveReportsTab() {
        clickOnThreePoints();
        WebElement Stakeholder = getElement(ExecutiveReportsXpath);
        Stakeholder.click();
        waitElementToBeClickable(ExecutiveReportsBaseXpath);
    }
    public static void clickOnContributingEntititesTab() {
        clickOnThreePoints();
        WebElement ContributingEntitites = getElement(ContributingEntititesXpath);
        ContributingEntitites.click();
        waitElementToBeClickable(ContributingEntititesBaseXpath);
    }
    public static void clickOnParticipatingEntitiesTab() {
        clickOnThreePoints();
        WebElement ParticipatingEntities = getElement(ParticipatingEntitiesXpath);
        ParticipatingEntities.click();
        waitElementToBeClickable(ParticipatingEntitiesBaseXpath);
    }
    public static void clickOnRisksTab() {
        clickOnThreePoints();
        WebElement Risks = getElement(RisksXpath);
        Risks.click();
        waitElementToBeClickable(RisksBaseXpath);
    }
    public static void clickOnRelatedStrategiesTab() {
        clickOnThreePoints();
        WebElement RelatedStrategies = getElement(RelatedStrategiesXpath);
        RelatedStrategies.click();
        waitElementToBeClickable(RelatedStrategiesBaseXpath);
    }
    public static void clickOnStrategiesTab() {
        clickOnThreePoints();
        WebElement RelatedStrategies = getElement(RelatedStrategiesXpath);
        RelatedStrategies.click();
        waitElementToBeClickable(RelatedStrategiesBaseXpath);
    }
    public static void clickOnSubObjectivesTab() {
        clickOnThreePoints();
        WebElement SubObjectives = getElement(SubObjectivesXpath);
        SubObjectives.click();
        waitElementToBeClickable(SubObjectivesBaseXpath);
    }
    public static void clickOnObjectivesTab() {
        clickOnThreePoints();
        WebElement SubObjectives = getElement(ObjectivesXpath);
        SubObjectives.click();
        waitElementToBeClickable(ObjectivesBaseXpath);
    }
    public static void clickOnThreePoints()
    {
        WebElement ObjectiveElement = getElement(ThreePointsXpath);
        ObjectiveElement.click();
        waitPageLoad();
    }

}

