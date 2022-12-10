package stepDefs;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
//import org.junit.Assert;

public class CRUDStepDefs {

	Response response;
	RequestSpecification request;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
		// Write code here that turns the phrase above into concrete actions

		request = RestAssured.given().baseUri(URI);

	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
		// Write code here that turns the phrase above into concrete actions
		response = request.get();

	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(expResponseCode, response.getStatusCode());

		System.out.println(response.getBody().asString());
	}

	@When("I enter the name as {string} and Salary as {string}")
	public void i_enter_the_name_as_and_Salary_as(String name, String salary) {
		// Write code here that turns the phrase above into concrete actions

		Map<String, Object> MapObj = new HashMap<String, Object>();

		MapObj.put("name", name);
		MapObj.put("salary", salary);

		response = request
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(MapObj)
				.post("employees/create");
	}

	@When("I perform the Delete operation")
	public void i_perform_the_Delete_operation() {
		// Write code here that turns the phrase above into concrete actions
		response = request.delete("employees/20");
	}
	
	
	
	@When("I update the name as {string}  and salaryas {string}")
	public void i_update_the_name_as_and_salaryas(String name, String salary) {
	    // Write code here that turns the phrase above into concrete actions
		Map<String, Object> MapObj=new HashMap<String,Object>();
		MapObj.put("name", name);
		MapObj.put("salary", salary);
		Response response=request
                  .contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .body(MapObj)
                  .put("employees/21");
	}

}
