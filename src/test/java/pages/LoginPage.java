package pages;
import org.openqa.selenium.By;
import utils.BaseClass;

public class LoginPage {

    public void enterUsername(String username) {
        BaseClass.driver.findElement(
                By.id("user-name")).sendKeys(username);
    }

    public void enterPassword(String password) {
        BaseClass.driver.findElement(
                By.id("password")).sendKeys(password);
    }

    public void clickLogin() {
        BaseClass.driver.findElement(
                By.id("login-button")).click();
    }

    public void isLoginPageDisplayed() {
        BaseClass.driver.findElement(
                By.id("user-name")).isDisplayed();
    }

    public void isProductPageDisplayed() {
        BaseClass.driver.findElement(
                By.className("title")).isDisplayed();
    }

    public void isErrorDisplayed(String error) {
        BaseClass.driver.findElement(
                By.cssSelector("[data-test='error']")
        ).isDisplayed();
    }
}
