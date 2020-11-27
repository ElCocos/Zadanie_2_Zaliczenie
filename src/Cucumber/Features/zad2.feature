Feature: Zad2

  Scenario:

    Given open browser and login
    When select Hummingbird Printed Sweater
    And select size and take 5 to cart
    And go to checkout
    And confirm address
    And select pick up in store
    Then pay method
    And take screen shot
