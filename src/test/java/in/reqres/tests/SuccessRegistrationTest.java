package in.reqres.tests;

import in.reqres.config.ConfigTest;
import in.reqres.models.lombok.RegisterUser;
import in.reqres.models.lombok.Response;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.tests.TestData.id;
import static in.reqres.tests.TestData.token;
import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Проверка сайта reqres.in")
@Story("Проверка сайта reqres.in")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://reqres.in/")

public class SuccessRegistrationTest extends ConfigTest {

    @DisplayName("Проверка успешной регистрации по API")
    @Test
    public void successLombokRegistration() {
        step("Регистрация пользователя и проверка токена", () -> {
            RegisterUser registerUserLombok = new RegisterUser();
            registerUserLombok.setEmail("eve.holt@reqres.in");
            registerUserLombok.setPassword("pistol");

            Response response = given()
                    .spec(requestSpecHeader)
                    .body(registerUserLombok)
                    .when()
                    .post("https://reqres.in/api/register")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200)
                    .extract()
                    .as(Response.class);

            assertThat(response.getId()).isEqualTo(id);
            assertThat(response.getToken()).isEqualTo(token);
        });
    }
}