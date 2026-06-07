package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.isLoginPageDisplayed();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(
            String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should see products page")
    public void user_should_see_products_page() {
        loginPage.isProductPageDisplayed();
    }

    @Then("user should see error {string}")
    public void user_should_see_error(String errorMessage) {
        loginPage.isErrorDisplayed(errorMessage);
    }
}
