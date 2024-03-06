package framework;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    protected JsonParser jsonParser = new JsonParser();
    protected Gson gson = new Gson();
    PropertyReader propertyReader = new PropertyReader("config.properties");

    public String get(String uri, int status, String... body){
        String string = given().
                header("Content-type", "application/json").
                get(propertyReader.getProperty("URL") + uri).
                then().
                log().all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();
        return string;
    }
    public String get(String uri, String postId, int status){
        String string = given().
                header("Content-type", "application/json").
                get(propertyReader.getProperty("URL") + uri + postId).
                then().
                log().all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();
        return string;
    }

    public String post(String body, String uri, int status){
        return  given().
                header("Content-type", "application/json").
                body(body).
                when().
                post(propertyReader.getProperty("URL") + uri).
                then().
                log().all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();
    }
}