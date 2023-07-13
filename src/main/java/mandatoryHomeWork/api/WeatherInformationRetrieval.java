package mandatoryHomeWork.api;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherInformationRetrieval {

	public static int city_id;
	public static int lat;
	public static int lon;
	public static String uri = "https://api.openweathermap.org/data/2.5";
	public static String api_key = "6cfda92d21f527094e02e423e094adf7";

	public static void main(String[] args) {
		get_Current_Weather_By_City_Name();
		get_Current_Weather_By_City_Id(city_id);
		get_Current_Weather_By_City_Id(city_id);
	}

	public static void get_Current_Weather_By_City_Name() {
		RestAssured.baseURI = uri;
		RestAssured.basePath = "/weather";
		HashMap<String, String> queryparams = new HashMap<String, String>();
		queryparams.put("appid", api_key);
		queryparams.put("q", "Dindigul");
		Response response = RestAssured.given().queryParams(queryparams).get();
		assertEquals(response.statusCode(), 200);
		city_id = response.jsonPath().get("id");
		System.out.println("1 scenario pass - " + response.statusCode());
	}

	private static void get_Current_Weather_By_City_Id(int city_id) {
		RestAssured.baseURI = uri;
		RestAssured.basePath = "/weather";
		HashMap<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("appid", api_key);
		queryparams.put("id", city_id);
		Response response = RestAssured.given().queryParams(queryparams).get();
		assertEquals(response.statusCode(), 200);
		System.out.println("2 scenario pass - " + response.statusCode());
	}
}
