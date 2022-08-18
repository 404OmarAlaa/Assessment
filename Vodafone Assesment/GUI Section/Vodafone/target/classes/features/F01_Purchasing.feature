@smoke
Feature: F01_Purchasing | user purchasing and item from vodafone web site

  Scenario: guest user couldn't purchase and item without filling personal information
    Given Go to Vodafone Shop using URL.
    When  Select language as English.
    And   Go to Shop By Brand section and select Iphone.
    And   Select any of returned iphone mobiles.
    And   Press add to cart
    And   Press proceed to checkout
    And   Select Delivery Options as Cairo Ain Shams.
    And   Select Deliver to My Address.
    And   Add address details
    And   Press continue
    And   Leave Personal info. Tab empty.
    Then  Assert on error message returned from Full Name field.
