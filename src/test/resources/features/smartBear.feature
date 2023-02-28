
  Feature: Smart Bear Software

    Background:
      Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
      When user enters username as "Tester"
      And user enters password as "test"



    @Smoke
      Scenario: Validate invalid login attempt
      When user enters username as "abcd"
      And user enters password as "abcd1234"
      And user clicks on Login button
      Then user should see "Invalid Login or Password." message

      @Smoke
      Scenario: Validate valid login attempt
      And user clicks on Login button


      @Regression
      Scenario: Validate “Web Orders” menu items
      And user clicks on Login button
        Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
      And validate below menu items are displayed
        | View all orders | View all products | Order |



    Scenario: Validate “Check All” and “Uncheck All” links
      And user clicks on Login button
      Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
      When user clicks on “Check All” button
      Then all rows should be checked
      When user clicks on “Uncheck All” button
      Then all rows should be unchecked