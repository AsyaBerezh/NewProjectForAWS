import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import javax.security.auth.login.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

/*****************************************************************************
 * Author:      Onur Baskirt
 * Description: This is the first Selenium TestNG test.
 *              It opens swtestacademy homepage and prints and checks its title.
 *******************************************************************************/

public class FirstTest {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void Seleniumtest1() {
        System.out.println("In test 1");
        driver.get("http://google.com");
        String expectedPageTitle = "Google";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
    }

    @Test
    public void Seleniumtest2() {
        System.out.println("In test 2");
    }

    @Test
    public void Seleniumtest3() {
        System.out.println("In test 3");
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null)
            driver.quit();
    }
}