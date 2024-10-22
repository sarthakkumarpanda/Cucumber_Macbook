package hooks;


import com.Utilities.ConfigReader;
import com.Utilities.Util;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.Properties;

import static com.Utilities.ConfigReader.prop;

public class MyHooks {
    public WebDriver driver;


    @Before
    public void setup() throws Exception{
       Properties prop = ConfigReader.initializePropertiesFile();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.get(prop.getProperty("url"));
    }


    @After
    public void tearDown(){
       driver.quit();
    }
}
