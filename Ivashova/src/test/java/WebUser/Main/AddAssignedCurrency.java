package WebUser.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAssignedCurrency
{

    public void ClickAddCurrency(ChromeDriver driver)
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/form/p/input")).click(); // Click button Add Assigned Currency //
    }

    public void AddCurrency(ChromeDriver driver, String Currency, String MinSalary, String MaxSalary)
    {
        WebElement currency = driver.findElement(By.id("payGradeCurrency_currencyName"));
        currency.sendKeys(Currency);// Select Currency //
        WebElement minSalary = driver.findElement(By.id("payGradeCurrency_minSalary"));
        minSalary.sendKeys(MinSalary);// Add Min Salary //
        WebElement maxSalary = driver.findElement(By.id("payGradeCurrency_maxSalary"));
        maxSalary.sendKeys(MaxSalary);// Add Max Salary //
    }

    public void SaveCurrency(ChromeDriver driver)
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/form/fieldset/p/input[1]")).click(); // Save Currency //
    }
}
