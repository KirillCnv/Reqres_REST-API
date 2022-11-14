package in.reqres.test;

import in.reqres.config.ConfigTest;
import in.reqres.models.lombok.LoginUserLombokBody;
import in.reqres.models.lombok.RegisterUserLombok;
import in.reqres.models.lombok.ResponseLombok;
import in.reqres.models.pojo.RegisterBodyPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;


public class RestApiTest extends ConfigTest {

    @DisplayName("Проверка удачной регистрации")
    @Test
    public void successPojoRegistration() {
        String token = "QpwL5tke4Pnpja7X4";
        RegisterUserLombok registerUserLombok = new RegisterUserLombok();
        registerUserLombok.setEmail("eve.holt@reqres.in");
        registerUserLombok.setPassword("pistol");

        ResponseLombok response = given()
                .spec(requestSpecHeader)
                .body(registerUserLombok)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract()
                .as(ResponseLombok.class);

        assertThat(response.getToken()).isEqualTo(token);
    }


    @DisplayName("Успешный вход в систему")
    @Test
    public void loginPojoTest() {
        LoginUserLombokBody createUserLombokBody = new LoginUserLombokBody();
        createUserLombokBody.setEmail("eve.holt@reqres.in");
        createUserLombokBody.setPassword("cityslicka");


        given()
                .spec(requestSpecHeader)
                .body(createUserLombokBody)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", notNullValue());

    }


    @DisplayName("Не успешный вход в систему")
    @Test
    public void notLoginPojoTest() {
        RegisterBodyPojo registerBodyPojo = new RegisterBodyPojo();
        registerBodyPojo.setEmail("peter@klaven");


        given()
                .spec(requestSpecHeader)
                .body(registerBodyPojo)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));

    }

    @DisplayName("Проверка с помощью Groovy")
    @Test
    public void groovyTest() {

        given()
                .spec(requestSpecHeader)
                .when()
                .get("/api/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.findAll{it.year}.year.flatten()", hasItem(2004));

    }

}


