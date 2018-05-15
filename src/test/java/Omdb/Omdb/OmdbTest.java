package Omdb.Omdb;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class OmdbTest {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("^a film exists wuth the Title IT$")
	public void a_film_exists_wuth_the_title_IT() {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retreives the film by title$")
	public void a_user_retreives_the_film_by_title() {
		response = request.when().get("http://www.omdbapi.com/?apikey=cf6dc63&t=IT&Y=2017");
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
		json = response.then().statusCode(200);
	}
}




