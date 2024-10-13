@Simplilearn
Feature: This feature will validate the login scenrios for simplilearn.com

  @Ignore
  Scenario: Validate the Login failure sceanrio
    Given I have launched the application
    And I click on login link
    When I enter username
    And I enter the password
    And I click on login button
    Then I should get the error message as "The email or password you have entered is invalid."

	@U_1000 @Regression
  Scenario: Validate the Login failure sceanrio
    Given I have launched the application
    And I click on login link
    When I enter username as "abc@xyz.com"
    And I enter the password as "Abc@1234"
    And I click on login button
    Then I should get the error message as "The email or password you have entered is invalid."

  Scenario Outline: Validate the Login failure sceanrio
    Given I have launched the application
    And I click on login link
    When I enter username as "<UserName>"
    And I enter the password as "<Password>"
    And I click on login button
    Then I should get the error message as "The email or password you have entered is invalid."

    Examples: 
      | UserName    | Password | Error                                              |
      | abc@xyz.com | Abc@1234 | The email or password you have entered is invalid. |
      | pqr@xyz.com | Pqr@1234 | The email or password you have entered is invalid. |

  @U_1000
  Scenario: Validate different login options present on the login screen
    Given I have launched the application
    And I click on login link
    Then I see the below login options present on the screen
      | Google   |
      | Facebook |
      | Linkedin |
      | Apple    |
