package WebUser.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization
{

    public void UserName(ChromeDriver driver, String Username)
    {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys(Username); // User fill username text box //
    }
    public void Password(ChromeDriver driver, String Password)
    {
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys(Password); // User fill password text box //
    }
    public void ClickLogin(ChromeDriver driver)
    {
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click(); // Click button Login //
    }
}
