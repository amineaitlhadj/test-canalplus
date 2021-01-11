Feature: Edit subcriber international adress

  Scenario: Edit the adress of a subscriber living abroad
    Given A subscriber with an adress and a subscriptions
    When The advisor edit the subscriber adress
    Then The adress is set only on the first subscription
    And A movement of adress modification is created
