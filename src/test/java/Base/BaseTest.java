package Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    private static final int TIMEOUT = 15;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cosva\\IdeaProjects\\gradleAllure\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     *  @AfterEach
     *   public void tearDown(){
     *       driver.close();
     *       driver.quit();
     * }
     */

    public static void switchTo(int window){
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> tabsArray = new ArrayList<>(tabs);
        driver.switchTo().window(tabsArray.get(window));
    }

    public static void switchTo(String pagePath){
        Set<String> tabs = driver.getWindowHandles();
        for(String tab : tabs){
            driver.switchTo().window(tab);
            if(driver.getCurrentUrl().startsWith(pagePath)){
                return;
            }
        }
        throw new RuntimeException("Вкладка не найдена");
    }

    public static boolean checkCookieContains(String key, String value){
        return driver.manage().getCookieNamed(key).getValue().contains(value);
    }

    public static boolean checkCookieEquals(String key, String value){
        return driver.manage().getCookieNamed(key).getValue().equals(value);
    }

}