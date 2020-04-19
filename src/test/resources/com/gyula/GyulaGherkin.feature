Feature: YourLogo registration

  Background:
    Given The homepage is opened

  Scenario Outline:
    Given The '<emailfield>' is filled with '<value>'
    Then The create account button is clicked
    Examples:
      | emailfield          | value                 |
      | email_create        | valami1@myemail.hu    |
      | email_create        | valamimas@myemail.hu  |

  Scenario:
    Given Invalid email address is added
    And Registration button is clicked
    Then Invalid email address error displayed


  Scenario:
    Given Email address is added
    And Registration button is clicked
    And The firstnamefield is filled
    And Gender added
    And The lastnamefield is filled
    And The passwordfield is filled
    And Birthday day added
    And Birthday month added
    And Birthday year added
    And Newsletter clicked
    And Company name added
    And Address added
    And City added
    And State added
    And Postal code added
    And Register button clicked
    Then A phone number missing error is displayed

  Scenario:
    Given Enter valid email
    And Enter valid password
    And Click on sign in button
    And Click on My Wishlist button
    And Add new wishlist name
    And Save new wishlist
    And Logout

  Scenario:
    Given Enter valid email
    And Enter valid password
    And Click on sign in button
    And Click on T-shirts
    And Select list view



