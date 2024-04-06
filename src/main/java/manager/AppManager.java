package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppManager {
//    ChromeOptions options = new ChromeOptions().addArguments("load-extension=C://Tools/5.10.1_0");

    WebDriver wd = new ChromeDriver();
    //WebDriver driverOptions = new ChromeDriver(options);

    default void init(){
        wd.navigate().to("https://demoqa.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    default void initAddOptions(){
//        driverOptions.navigate().to("https://demoqa.com/");
//        driverOptions.manage().window().maximize();
//        driverOptions.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        List<String>tabs = new ArrayList<>(driverOptions.getWindowHandles());
//        for (String tab: tabs){
//            System.out.println("--> "+tab);
//        }
//        driverOptions.switchTo().window(tabs.get(1)).close();
//        driverOptions.switchTo().window(tabs.get(0));
//    }

    default void stop(){
        wd.quit();
    }

}
