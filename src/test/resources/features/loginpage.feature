Feature: Login functionality for Saucedemo

  @Regression @Smoke @Positive
  Scenario: Valid login with standard user
    Given user is on login page
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks login button
    Then user should see products page

  @Regression @Positive
  Scenario: Login with performance glitch user
    Given user is on login page
    When user enters username "performance_glitch_user" and password "secret_sauce"
    And user clicks login button
    Then user should see products page

  @Regression @Negative @vk150
  Scenario: Login with locked out user
    Given user is on login page
    When user enters username "locked_out_user" and password "secret_sauce"
    And user clicks login button
    Then user should see error "Sorry, this user has been locked out"

  @Regression @Negative
  Scenario: Login with wrong password
    Given user is on login page
    When user enters username "standard_user" and password "wrong123"
    And user clicks login button
    Then user should see error "Username and password do not match"

  @Regression @Negative
  Scenario: Login with empty username
    Given user is on login page
    When user enters username "" and password "secret_sauce"
    And user clicks login button
    Then user should see error "Username is required"

  @Regression @Negative
  Scenario: Login with empty password
    Given user is on login page
    When user enters username "standard_user" and password ""
    And user clicks login button
    Then user should see error "Password is required"

  @Regression @Negative
  Scenario: Login with both fields empty
    Given user is on login page
    When user enters username "" and password ""
    And user clicks login button
    Then user should see error "Username is required"
