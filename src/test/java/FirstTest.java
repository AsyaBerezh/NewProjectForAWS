import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import javax.security.auth.login.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {

    //Declare a Webdriver variable
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        System.setProperty("webdriver.chrome.driver", getPathToDriver());
        driver = new ChromeDriver(options);
    }

    @Test
    public void Seleniumtest1() {
        System.out.println("In test 1");
        driver.get("http://google.com");
        String expectedPageTitle = "Google";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
    }
    private String getPathToDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("win")) {
            return this.getClass().getResource("/chromedriver_windows32/chromedriver.exe").getPath();
        }
        if(osName.contains("mac")) {
            return this.getClass().getResource("/chromedriver_mac64/chromedriver").getPath();
        }
        if(osName.contains("nux")) {
            return "src/test/resources/chromedriver_linux64/chromedriver";
        }
        throw new RuntimeException("Your system type was not detected! Please download and set chromedriver by yourself");
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