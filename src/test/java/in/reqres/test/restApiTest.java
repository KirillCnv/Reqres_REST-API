package in.reqres.test;

import in.reqres.config.ConfigTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class restApiTest extends ConfigTest {

    @DisplayName("Проверка удачной регистрации")
    @Test
    public void successRegistration() {
        TestData testData = new TestData();
        testData
                .setEmail("eve.holt@reqres.in")
                .setPassword("pistol");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @DisplayName("Проверка неудачной регистрации")
    @Test
    public void notSuccessRegistration() {
        TestData testData = new TestData();
        testData
                .setEmail("sydney@fife");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @DisplayName("Создать пользователя")
    @Test
    public void createUser() {
        TestData testData = new TestData();
        testData
                .setName("morpheus")
                .setJob("leader");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());

    }

    @DisplayName("Успешный вход в систему")
    @Test
    public void loginTest() {
        TestData testData = new TestData();
        testData
                .setEmail("eve.holt@reqres.in")
                .setPassword("cityslicka");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));

    }


    @DisplayName("Не успешный вход в систему")
    @Test
    public void notLoginTest() {
        TestData testData = new TestData();
        testData
                .setEmail("peter@klaven");

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(testData)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));

    }


}


