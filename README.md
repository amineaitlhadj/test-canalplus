# test-canalplus


Test Java for testing scenarios.

After project configuration and adding all the necessaery maven dependencies.

I write my models : Subscriber, Subscription, Movement

I Implement my services : SubscriberServiceImpl, SubscriptionServiceImpl, MovementServiceImpl

I Implement the controller : SubscriberController, SubscriptionController, MovementController

Launch the project with Tomcat Server and navigate to :

http://localhost:8080/test/subscriber/subscribers

We'll get our subscribers initialized in the H2 database.

We can navigate to :

http://localhost:8080/test/subscription/subscriptions

We'll get all the subscriptions.

We can also perform all the cruds operations: 

POST : http://localhost:8080/test/subscriber/subscribers with a requestBody:

{
    "id": 2,
    "nom": "Ait Lhadj",
    "prenom": "Amine",
    "adresse": "166 boulevard charles de gaulle",
    "subscriptions": []
}

PUT : to edit the adress on : http://localhost:8080/test/subscriber/subscribers with a requestBody : 

{
	"id" : 1,
	"nom" : "Ait Lhadj",
	"prenom" : "Amine",
	"adresse" : "166 boulevard charles de gaulle"
}


###Cucumber Scenarios###

After adding the maven dependencies for cucumber, gherkin, junit.

I Write my editAdress.feature where i write the scenarios to test. 

I write my file stepDefinitions where i implement the gherkin steps. 

And my RunTest Class where we launch the tests. After launching the tests with JUnit, we see that all the scenarios have been executed correctly.

####Qualité de code 

Pour la qualité de code, j'ai essayé de mettre en place l'approche TDD, en écrivant les cas de tests avant de commencer mes implémentations.

J'ai intégré mon projet dans une organisation SonarQube pour lancer le rapport Sonar et pouvoir detecter tous les bugs et les erreurs. 


