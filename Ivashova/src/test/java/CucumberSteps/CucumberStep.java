package CucumberSteps;

import WebUser.Main.AddAssignedCurrency;
import WebUser.Main.AddPayGradeRecord;
import WebUser.Main.Authorization;
import WebUser.Main.DeleteAndCheckRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(publish = true)
public class CucumberStep {

    public static ChromeDriver driver;
    public Authorization AuthorizationUser;
    public AddPayGradeRecord Record;
    public AddAssignedCurrency CurrencyRecord;
    public DeleteAndCheckRecord DeleteRecord;

    @Given("User launch Chrome browser")
    public void userLaunchChromeBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        AuthorizationUser = new Authorization();
    }

    @When("User opens URL {string}")
    public void userOpensURL(String URL)
    {
        driver.get(URL);
    }

    @And("User fill Username text box {string} and Password text box {string}")
    public void userFillUsernameTextBoxAndPasswordTextBox(String Username, String Password)
    {
        AuthorizationUser.UserName(driver, Username);
        AuthorizationUser.Password(driver, Password);
    }

    @And("Click on Login")
    public void clickOnLogin()
    {
        AuthorizationUser.ClickLogin(driver);
    }

    @Then("User go to the menu page")
    public void userGoToTheMenuPage()
    {

    }

    public void OneStepsMissing()
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        AuthorizationUser = new Authorization();
        AuthorizationUser.UserName(driver, "Admin");
        AuthorizationUser.Password(driver, "admin123");
        AuthorizationUser.ClickLogin(driver);
    }

    @Given("User native to Pay Grade page")
    public void userNativeToPayGradePage()
    {
        OneStepsMissing();
        Record = new AddPayGradeRecord();
        Record.FollowToPayGradePage(driver);
    }

    @When("User click button Add Pay Grade")
    public void userClickButtonAddPayGrade()
    {
        Record.ClickAddRecord(driver);
    }

    @And("User fill Name text box {string}")
    public void userFillNameTextBox(String RandomName)
    {
        Record.AddRandomName(driver, RandomName);
    }

    @And("User save name in the Pay Grade page")
    public void userSaveNameInThePayGradePage()
    {
        Record.SaveRandomName(driver);
    }


    @Then("User can see saved Random name and message Successfully Saved")
    public void userCanSeeSavedRandomNameAndMessageSuccessfullySaved()
    {

    }

    public void TwoStepsMissing()
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        AuthorizationUser = new Authorization();
        AuthorizationUser.UserName(driver, "Admin");
        AuthorizationUser.Password(driver, "admin123");
        AuthorizationUser.ClickLogin(driver);
        AddPayGradeRecord addRecord = new AddPayGradeRecord();
        addRecord.FollowToPayGradePage(driver);
        addRecord.ClickAddRecord(driver);
        addRecord.AddRandomName(driver, "Nastia");
        addRecord.SaveRandomName(driver);
    }

    @Given("User created record on the Pay Grade page")
    public void userCreatedRecordOnThePayGradePage()
    {
        TwoStepsMissing();
        CurrencyRecord = new AddAssignedCurrency();
    }

    @When("User click button Add Assigned Currency")
    public void userClickButtonAddAssignedCurrency()
    {
        CurrencyRecord.ClickAddCurrency(driver);
    }

    @And("User fill Currency text box {string}, Min Salary text box {string} and Max Salary {string}")
    public void userFillCurrencyTextBoxMinSalaryTextBoxAndMaxSalary(String Currency, String MinSalary, String MaxSalary)
    {
        CurrencyRecord.AddCurrency(driver, Currency, MinSalary, MaxSalary);
    }

    @And("User save assigned currency in record")
    public void userSaveAssignedCurrencyInRecord()
    {
        CurrencyRecord.SaveCurrency(driver);
    }


    @Then("User can see saved Assigned Currency message Successfully Saved")
    public void userCanSeeSavedAssignedCurrencyMessageSuccessfullySaved()
    {

    }

    public void ThreeStepsMissing()
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Authorization authorization = new Authorization();
        authorization.UserName(driver, "Admin");
        authorization.Password(driver,"admin123");
        authorization.ClickLogin(driver);

        AddPayGradeRecord addRecord = new AddPayGradeRecord();
        addRecord.FollowToPayGradePage(driver);
        addRecord.ClickAddRecord(driver);
        addRecord.AddRandomName(driver, "Sveta");
        addRecord.SaveRandomName(driver);

        AddAssignedCurrency addCurrency = new AddAssignedCurrency();
        addCurrency.ClickAddCurrency(driver);
        addCurrency.AddCurrency(driver, "UAH - Ukraine Hryvnia","15000",  "30000");
        addCurrency.SaveCurrency(driver);
    }

    @Given("User see on created record on the Pay Grade page")
    public void userSeeOnCreatedRecordOnThePayGradePage()
    {
        ThreeStepsMissing();
        DeleteRecord = new DeleteAndCheckRecord();
    }

    @When("User select record and delete it")
    public void userSelectRecordAndDeleteIt()
    {
        DeleteRecord.DeleteAndCheck(driver, "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[2]");
    }


    @Then("User can see that record is deleted message Successfully Deleted")
    public void userCanSeeThatRecordIsDeletedMessageSuccessfullyDeleted()
    {

    }
}
