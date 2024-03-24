package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class XpahLocators {
    WebDriver wd;

    @BeforeMethod
    public void preConditions(){
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/checkbox");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void firstXpath(){
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement btnToggleHome = wd.findElement(By.xpath("Toggle"));
        btnToggleHome.click();

        WebElement checkBoxDesktop = wd.findElement(By.xpath("//label[@for='tree-node-desktop']"));
        System.out.println("X --> " + checkBoxDesktop.getLocation().getX());
        System.out.println("Y --> " + checkBoxDesktop.getLocation().getY());

        wd.quit();
    }
}
