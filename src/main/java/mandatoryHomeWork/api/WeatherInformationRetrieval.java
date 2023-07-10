package mandatoryHomeWork.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WeatherInformationRetrieval {
	public static void main(String[] args) {
		createUser();
	}

	public static void createUser() {
		// set url
		RestAssured.baseURI = "https://reqres.in";
		// set base path
		RestAssured.basePath = "/api/user";
		// prepare request
		Map<String, String> queryParam = new HashMap<>();
		queryParam.put("id", "2");
		Response response = RestAssured.given().queryParams(queryParam).accept(ContentType.JSON).when().get();

		response.prettyPrint();
		 System.out.println(response.statusCode());
		List<String> list = response.jsonPath().getList("data");
		System.out.println(list);
	}
}
