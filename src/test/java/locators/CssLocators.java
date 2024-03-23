package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CssLocators {
    WebDriver driver;

    @Test
    public void start(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement elementFullName = driver.findElement(By.cssSelector("input"));
        System.out.println("---> "+elementFullName.getAttribute("placeholder"));

        WebElement elementEmail = driver.findElement(By.cssSelector("input[type='email']"));
        System.out.println("---> "+elementEmail.getAttribute("placeholder"));

        WebElement elementCurrAddress = driver.findElement(By.cssSelector("#currentAddress"));
        System.out.println("---> "+elementCurrAddress.getAttribute("class"));
        System.out.println("---> "+elementCurrAddress.getTagName());

         driver.quit();
    }

    @Test
    public void buttons(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement btnDoubleClickMe = driver.findElement(By.cssSelector("#doubleClickBtn"));
        System.out.println("-->"+btnDoubleClickMe.getText());

        WebElement btnRightClickMe = driver.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6'] div[class='mt-4']>button"));
        System.out.println("-->"+btnRightClickMe.getText());

        List<WebElement> btnList = driver.findElements(By.cssSelector
                ("div[class='col-12 mt-4 col-md-6'] div[class='mt-4']>button"));
        System.out.println("size -->"+btnList.size());
        for (WebElement el: btnList){
            System.out.println("text --> "+el.getText());

        }

        driver.quit();
    }

}
