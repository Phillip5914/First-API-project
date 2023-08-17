import org.json.simple.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class APIpro {

	JSONObject req = new JSONObject();
	
	@Test
	void delayed() {
		Response response = get("https://reqres.in/api/users?delay=3");
		
		given().
		   get("https://reqres.in/api/users?delay=3").
		then().
		   statusCode(200).
		log().all().body("data.id[2]",equalTo(3));
	}
	@Test
	void unsuccessful() {
		given().
		    body(req.toJSONString()).
		when().
		    post("https://reqres.in/api/login").
		then().
		    statusCode(400).
		log().all();

	}

}
