package vn.sunasterisk.facebookautomationtest.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginPageTest {
    public String email;
    public String password;
    public void loginFacebook (String email, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.facebook.com");

        WebElement emailElement = webDriver.findElement(By.xpath("//*[@id='email']"));
        emailElement.sendKeys(email);

        WebElement passwordElement = webDriver.findElement(By.xpath("//*[@id='pass']"));
        passwordElement.sendKeys(password);

        WebElement loginbutton = webDriver.findElement(By.xpath("//*[@name = 'login']"));
        loginbutton.click();

        Thread.sleep(5000);

        List searchinputs = (List) webDriver.findElements(By.xpath("//*[@type='search']"));
        if(searchinputs.size() > 0) {
            System.out.println("[" + email + "]" +  "-" + "[" + password + "]"+ "Login thành công");
        }
        else
        {
            WebElement errorDiv = webDriver.findElement(By.className("_9ay7"));
            System.out.println("[" + email + "]" +  "-" + "[" + password + "]" + errorDiv.getText());
        }

        Thread.sleep(10000);
        webDriver.close();
        webDriver.quit();


    }
}
