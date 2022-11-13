package in.reqres.spec;

import in.reqres.helpers.CustomListener;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class SpecRequest {
    public static RequestSpecification requestSpecHeader = with()
            .filter(CustomListener.withCustomTemplates())
            .baseUri("https://reqres.in")
            .log().uri()
            .log().body()
            .contentType(JSON);


}
