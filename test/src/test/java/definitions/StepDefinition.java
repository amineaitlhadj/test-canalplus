package definitions;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;

import com.canalplus.test.Model.Subscriber;
import com.canalplus.test.Model.Subscription;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefinition {
	
	private static String jsonString;
	private static Response response;
	private static long id = 1;
	private static String nom = "Ait Lhadj";
	private static String prenom = "Amine";
	private static String adresse = "166 boulevard Charles de Gaulle";
	
	private static long id1 = 2;
	private static String nom1 = "Fisher";
	private static String prenom1 = "Jack";
	private static String adresse1 = "144 Michigan";
	
	@Given("^A subscriber with an adress and a subscriptions$")
	public void a_subscriber_with_an_adress_and_a_subscriptions() throws Throwable {
	    RestAssured.baseURI = "http://localhost:8080";
	    RequestSpecification request = RestAssured.given();
	    response = request.get("/test/subscriber/subscribers");
	    jsonString = response.asString();
	    List<Map<String, String>> subscribers = JsonPath.from(jsonString).get("subscribers");
	    Assert.assertTrue(subscribers.size() > 0);
	    Assert.assertEquals(302, response.getStatusCode());
	}

	@When("^The advisor edit the subscriber adress$")
	public void the_advisor_edit_the_subscriber_adress() throws Throwable {
	    RestAssured.baseURI = "http://localhost:8080";
	    RequestSpecification request = RestAssured.given();
	    request.header("Content-type", "application/json");
	    response = request.body("{ \"id\": \"" + id + "\", \"nom\": \""+nom+ "\",  \"prenom \": \"" + prenom + "\", \"adresse\": \""
	    		+ adresse+ "\" }").put("/test/subscriber/subscribers");
	    Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("^The adress is set on all the subscriptions$")
	public void the_adress_is_set_on_all_the_subscriptions() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    response = request.get("/test/subscriber/subscribers");
		    List<Subscriber> subscribers = Arrays.asList(response.getBody().as(Subscriber[].class));
		    Subscriber sub = subscribers.get(0);
		    Set<Subscription> subscriptions = sub.getSubscriptions();
		    for (Subscription subs : subscriptions) {
		    	String adresse = subs.getAdresse();
		    	Assert.assertEquals(adresse, adresse);
		    }
		    
		    Assert.assertEquals(302, response.getStatusCode());
		    
	}

	@Then("^A movement of adress modification is created$")
	public void a_movement_of_adress_modification_is_created() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    response = request.get("/test/movement/movements");
		    jsonString = response.asString();
		    List<Map<String, String>> movements = JsonPath.from(jsonString).get("subscribers");
		    Assert.assertTrue(movements.size() > 0);
		    Assert.assertEquals(302, response.getStatusCode());
	}
	
	
	@Given("^A subscriber with an adress abroad and a subscriptions$")
	public void a_subscriber_with_an_adress_abroad_and_a_subscriptions() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    response = request.get("/test/subscriber/subscribers");
		    jsonString = response.asString();
		    List<Map<String, String>> subscribers = JsonPath.from(jsonString).get("subscribers");
		    Assert.assertTrue(subscribers.size() > 0);
		    Assert.assertEquals(302, response.getStatusCode());
	}
	
	@When("^The advisor edit the subscriber adress abroad$")
	public void the_advisor_edit_the_subscriber_adress_abroad() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    request.header("Content-type", "application/json");
		    response = request.body("{ \"id\": \"" + id1 + "\", \"nom\": \""+nom1+ "\",  \"prenom \": \"" + prenom1 + "\", \"adresse\": \""
		    		+ adresse1+ "\" }").put("/test/subscriber/subscribers/abroad");
		    Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Then("^The adress is set only on the first subscription$")
	public void the_adress_is_set_only_on_the_first_subscription() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    response = request.get("/test/subscriber/subscribers");
		    List<Subscriber> subscribers = Arrays.asList(response.getBody().as(Subscriber[].class));
		    Subscriber sub = subscribers.get(1);
		    Set<Subscription> subscriptions = sub.getSubscriptions();
		    Subscription subs = subscriptions.stream().findFirst().get();
		    String adresse = subs.getAdresse();
		    Assert.assertEquals(adresse, adresse1);
		    Assert.assertEquals(302, response.getStatusCode());
	}
	
	@Then("^A movement of adress abroad modification is created$")
	public void a_movement_of_adress_abroad_moodification_is_created() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
		    RequestSpecification request = RestAssured.given();
		    response = request.get("/test/movement/movements");
		    jsonString = response.asString();
		    List<Map<String, String>> movements = JsonPath.from(jsonString).get("subscribers");
		    Assert.assertTrue(movements.size() > 0);
		    Assert.assertEquals(302, response.getStatusCode());
	}
	
}
