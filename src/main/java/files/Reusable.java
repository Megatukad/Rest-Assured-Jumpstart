package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Reusable {

    public static JsonPath rawToJson(Response r) {
        String response = r.asString();
        JsonPath js = new JsonPath(response);
        return js;
    }

}
