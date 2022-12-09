package in.reqres.tests;

import in.reqres.models.lombok.RegisterUser;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Feature("Проверка сайта reqres.in")
@Story("Проверка сайта reqres.in")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://reqres.in/")

public class NonAuthApiTest {

    @DisplayName("Безуспешная авторизация по API")
    @Test
    public void notLoginPojoTest() {
        step("Проверка авторизации ", () -> {
            RegisterUser registerBodyPojo = new RegisterUser();
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

        });
    }
}