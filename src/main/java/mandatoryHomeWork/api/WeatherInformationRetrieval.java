package mandatoryHomeWork.api;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherInformationRetrieval {
	public static void main(String[] args) {
		get_Current_Weather_By_City_Name();
	}

	public static void get_Current_Weather_By_City_Name() {
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
		RestAssured.basePath = "/weather";
		HashMap<String, String> queryparams = new HashMap<String, String>();
		queryparams.put("appid", "6cfda92d21f527094e02e423e094adf7");
		queryparams.put("q", "Dindigul");
		Response response = RestAssured.given().queryParams(queryparams).get();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		String categories = response.jsonPath().get("response.name");
		System.out.println(categories);
	}
}
