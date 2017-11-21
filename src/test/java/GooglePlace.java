import files.Endpoint;
import files.Payload;
import files.Reusable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GooglePlace {

    Properties prop =new Properties();
    @BeforeTest
    public void Properties() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/megs/Documents/RestAssuredAPI/src/main/resources/env.properties");
        prop.load(fis);
    }

    @Test
    public void getGooglePlace(){
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                param("location","-33.8670522,151.1957362").
                param("radius","500").
                param("key", prop.getProperty("KEY")).
        when().
                get(Endpoint.getPlaceData()).
        then(). assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("results[0].name",equalTo("Sydney")).and().
                body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().log().all();
    }

    @Test
    public void PostPlace(){
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                queryParam("key", prop.getProperty("KEY")).
                body(Payload.postData()).
        when().
                post(Endpoint.placePostData()).
        then(). assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("status",equalTo("OK")).log().all();
    }



}
