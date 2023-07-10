package mandatoryHomeWork.selenium;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class test {

	@Test
	public void createUser() {
		// set url
		RestAssured.baseURI = "https://reqres.in";
		// set base path
		RestAssured.basePath = "/api";
		// prepare request
		Response response = RestAssured.given().log().all().header(new Header("Content-Type", "application/json"))
				.when().get("/user/2").then().log().all().statusCode(200).extract().response();

		response.prettyPrint();

	}

}
