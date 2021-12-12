package WebUser.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteAndCheckRecord
{
    public void DeleteAndCheck(ChromeDriver driver, String XPATH)
    {
        String userId = driver.findElement(By.id("payGrade_payGradeId")).getAttribute("defaultValue");
        WebElement buttonXPATH = driver.findElement(By.xpath(XPATH));
        buttonXPATH.click();
        driver.findElement(By.id("ohrmList_chkSelectRecord_"+userId)).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
}
