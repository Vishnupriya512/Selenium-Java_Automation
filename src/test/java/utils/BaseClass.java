package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static WebDriver driver;
    public static void initializeDriver(){
        String browser = ConfigReader.get("browser");
        if (browser.equals("chrome")){
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")){
            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    public static void quitDriver() {
        if (Driver != null) {
            driver.quit();
        }
    }
}

