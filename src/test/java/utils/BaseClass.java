package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public static WebDriver driver;

    public static void initializeDriver() throws Exception {
        String execution = ConfigReader.get("execution");
        String browser = ConfigReader.get("browser");

        System.out.println("Execution: " + execution);
        System.out.println("Browser: " + browser);

        if(execution.equalsIgnoreCase("local")) {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }

        } else if(execution.equalsIgnoreCase("sauce")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");

            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username",
                    ConfigReader.get("sauce_username"));
            sauceOptions.put("accessKey",
                    ConfigReader.get("sauce_accesskey"));
            sauceOptions.put("build", "BDD-Build-1");
            sauceOptions.put("name", "Login Tests");
            caps.setCapability("sauce:options", sauceOptions);

            URL sauceURL = new URL(
                    ConfigReader.get("sauce_url"));
            driver = new RemoteWebDriver(sauceURL, caps);
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
