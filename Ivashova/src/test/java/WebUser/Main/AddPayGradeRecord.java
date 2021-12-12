package WebUser.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPayGradeRecord
{
    public void FollowToPayGradePage(ChromeDriver driver)
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b")).click(); // Click button Admin //
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click(); // Click button Job //
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/ul/li[2]/a")).click(); // Click button Pay Grade //
    }

    public void ClickAddRecord(ChromeDriver driver)
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/form/div[1]/input[1]")).click(); // Click button Add //
    }

    public void AddRandomName(ChromeDriver driver, String Record)
    {
        WebElement record = driver.findElement(By.id("payGrade_name"));
        record.sendKeys(Record); // Add Random Name //
    }

    public void SaveRandomName(ChromeDriver driver)
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/form/fieldset/p/input[1]")).click(); // Save Record//
    }

}
