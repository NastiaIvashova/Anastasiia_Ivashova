package WebUser.Main;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Authorization authorization = new Authorization();
        authorization.UserName(driver, "Admin"); // Add username in text box //
        authorization.Password(driver,"admin123"); //Add password in text box //
        authorization.ClickLogin(driver); // Click button Login //

        AddPayGradeRecord addRecord = new AddPayGradeRecord();
        addRecord.FollowToPayGradePage(driver); // User navigate to the Pay Grade page//
        addRecord.ClickAddRecord(driver); // Click button Add //
        addRecord.AddRandomName(driver, "Anna"); // Add Random Name in the Record//
        addRecord.SaveRandomName(driver); // Save Random Name in the Record//

        AddAssignedCurrency addCurrency = new AddAssignedCurrency();
        addCurrency.ClickAddCurrency(driver); // Click button Add //
        addCurrency.AddCurrency(driver, "UAH - Ukraine Hryvnia","15000",  "30000"); // Add Assigned Currency //
        addCurrency.SaveCurrency(driver); // Save Assigned Currency //

        DeleteAndCheckRecord selectedRecord = new DeleteAndCheckRecord();
        selectedRecord.DeleteAndCheck(driver, "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[2]");

    }
}

