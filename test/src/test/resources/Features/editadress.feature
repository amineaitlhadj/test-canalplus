Feature: Edit subcriber adress

  Scenario: Edit the adress of a subscriber living in France
    Given A subscriber with an adress and a subscriptions
    When The advisor edit the subscriber adress
    Then The adress is set on all the subscriptions
    And A movement of adress modification is created

    
  
  Scenario: Edit the adress of a subscriber living Abroad
  	Given A subscriber with an adress abroad and a subscriptions
  	When The advisor edit the subscriber adress abroad 
  	Then The adress is set only on the first subscription
  	And A movement of adress abroad modification is created
  