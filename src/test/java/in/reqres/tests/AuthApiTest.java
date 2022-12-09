package in.reqres.tests;

import in.reqres.models.lombok.LoginUserBody;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Проверка сайта reqres.in")
@Story("Проверка сайта reqres.in")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://reqres.in/")

public class AuthApiTest {
    @DisplayName("Успешный вход в систему по API")
    @Test
    public void loginLombokTest() {
        step("Проверка авторизации ", () -> {
            LoginUserBody createUserLombokBody = new LoginUserBody();
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
        });
    }
}