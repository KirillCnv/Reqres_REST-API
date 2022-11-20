package in.reqres.pages;

import in.reqres.models.lombok.LoginUserLombokBody;
import in.reqres.models.lombok.RegisterUserLombok;
import in.reqres.models.lombok.ResponseLombok;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static in.reqres.test.TestData.token;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestApiTestPage {


    @Step("Регистрация пользователя")
    public RestApiTestPage registrationUser() {

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

        return this;
    }

    @Step("Авторизация пользователя")
    public RestApiTestPage authUser() {

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

        return this;
    }

    @Step("Безуспешная авторизация")
    public RestApiTestPage failAuth() {

        RegisterUserLombok registerBodyPojo = new RegisterUserLombok();
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

        return this;
    }

    @Step("Проверка наличия даты")
    public RestApiTestPage groovyTest() {

            given()
                    .spec(requestSpecHeader)
                    .when()
                    .get("/api/unknown")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200)
                    .body("data.findAll{it.year}.year.flatten()", hasItem(2004));

        return this;
    }
}
