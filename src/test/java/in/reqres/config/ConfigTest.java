package in.reqres.config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ConfigTest {

    @BeforeAll
    static void configure(){
        RestAssured.baseURI = "https://reqres.in/";
    }
}
