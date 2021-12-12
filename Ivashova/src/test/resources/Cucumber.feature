@selenium
  Feature: Work with https://opensource-demo.orangehrmlive.com/
    Scenario: Successful login with valid credentials
      Given User launch Chrome browser
      When User opens URL "https://opensource-demo.orangehrmlive.com/"
      And User fill Username text box "Admin" and Password text box "admin123"
      And Click on Login
      Then User go to the menu page

    Scenario: Add Random name on the Pay Grade page
      Given User native to Pay Grade page
      When User click button Add Pay Grade
      And User fill Name text box "Anna"
      And User save name in the Pay Grade page
      Then User can see saved Random name and message Successfully Saved

    Scenario: Add Assigned Currency in user's record
      Given User created record on the Pay Grade page
      When User click button Add Assigned Currency
      And User fill Currency text box "UAH - Ukraine Hryvnia", Min Salary text box "15000" and Max Salary "30000"
      And User save assigned currency in record
      Then User can see saved Assigned Currency message Successfully Saved

    Scenario: Delete Record on the Pay Grade page
      Given User see on created record on the Pay Grade page
      When User select record and delete it
      Then User can see that record is deleted message Successfully Deleted