Feature: Test Facebook Login

  Scenario: Test login in with valid credentials
    Given Open Chrome browser and application
    When I enter valid "vishalrathi0@gmail.com" and valid "vishalisgoo"
    Then Sucessfully login into facebook
