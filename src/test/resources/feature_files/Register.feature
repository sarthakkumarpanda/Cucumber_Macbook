@TutorialsNinjaRegister
  Feature: Register Functionality of Tutorials Ninja


    @RegisterWithMandatoryDetails
    Scenario: Register with mandatory details
      Given User navigates to RegisterPage
      And User enters the below mandatory details
      |firstname | Selenium |
      |lastname  | Panda    |
      |telephone | 9876543210 |
      |password | Selenium@123 |
      |confirmpassword | Selenium@123 |
      And User selects Privacy Policy checkbox
      When User clicks on Continue button
      Then User account gets created successfully

    @AllFields
    Scenario: Register with all Fields
      Given User navigates to RegisterPage
      And User enters the below all details
        | firstname       | Selenium     |
        | lastname        | Panda        |
        | telephone       | 9876543210   |
        | password        | Selenium@123 |
        | confirmpassword | Selenium@123 |
      And User selects Yes for Newsletter
      And User selects Privacy Policy checkbox
      When User clicks on Continue button
      Then User account gets created successfully

    @DuplicateEmail
    Scenario: Register with existing email
      Given User navigates to RegisterPage
      And User enters below fields with existing email
        |firstname|Selenium|
        |lastname|Panda|
        |email|seleniumpanda@gmail.com|
        |telephone|9876543210|
        |password|Selenium@123|
        | confirmpassword | Selenium@123 |
      And User selects Yes for Newsletter
      And User selects Privacy Policy checkbox
      When User clicks on Continue button
      Then User gets warning message of duplicate email


      @IncorrectConfirmPassword
      Scenario: Register with incorrect password
        Given User navigates to RegisterPage
        And User enters below fields with incorrect password
          |firstname|Selenium|
          |lastname|Panda|
          |telephone|9876543210|
          |password|Selenium@123|
          | confirmpassword | Selenium@123456 |
        And User selects Yes for Newsletter
        And User selects Privacy Policy checkbox
        When User clicks on Continue button
        Then User gets warning message of incorrectConfirmPassword

        @LessThan4DigitsPassword
        Scenario: Register with password less than four characters
          Given User navigates to RegisterPage
          And User enters below fields with less than four characters for password
            |firstname|Selenium|
            |lastname|Panda|
            |email|seleniumpanda@gmail.com|
            |telephone|9876543210|
            |password|Sel|
            | confirmpassword | Sel |
          And User selects Yes for Newsletter
          And User selects Privacy Policy checkbox
          When User clicks on Continue button
          Then User gets warning message of password cannot be less than certain characters



    @NoFields
    Scenario: Register with no fields
      Given User navigates to RegisterPage
      When User clicks on Continue button
      Then User gets warning message for every mandatory field