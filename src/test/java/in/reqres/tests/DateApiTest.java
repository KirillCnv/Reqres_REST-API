package in.reqres.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.spec.SpecRequest.requestSpecHeader;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

@Feature("Проверка сайта reqres.in")
@Story("Проверка сайта reqres.in")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://reqres.in/")

public class DateApiTest {
    @DisplayName("API тест на наличие даты с использованием Groovy")
    @Test
    public void groovyTest() {
        step("Проверка блока на наличие даты ", () -> {
            given()
                    .spec(requestSpecHeader)
                    .when()
                    .get("/api/unknown")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(200)
                    .body("data.findAll{it.year}.year.flatten()", hasItem(2004));
        });
    }
}