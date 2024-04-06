package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager {
    default void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('div[id=\"fixedban\"]').style.display='none'");
    }
    default void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector(\"footer\").style.display='none'");
    }

    default void pause(int sec){
        try {
            Thread.sleep(1000L*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void clickBase(By locator){
        wd.findElement(locator).click();
    }

    default void typeBase(By locator, String text){
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    default boolean isElementPresent(By locator){
        return !wd.findElements(locator).isEmpty();
    }

    default boolean isElementEqualsTo(By locator, String text){
        return wd.findElement(locator).getText().equals(text);
    }

}
