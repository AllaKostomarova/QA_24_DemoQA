package tests;

import manager.AppManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase implements AppManager {

    @BeforeSuite
    public void setup(){
        init();
        //initAddOptions();

    }

    @AfterSuite
    public void tearDown(){
      //  stop();
    }
}
