package in.reqres.test;

import in.reqres.config.ConfigTest;
import in.reqres.pages.RestApiTestPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class RestApiTest extends ConfigTest {

    RestApiTestPage restApiTestPage = new RestApiTestPage();

    @DisplayName("Проверка успешной регистрации по API")
    @Test
    public void successLombokRegistration() {
        step("Регистрация пользователя и проверка токена", () -> {
            restApiTestPage.registrationUser();
        });
    }


    @DisplayName("Успешный вход в систему по API")
    @Test
    public void loginLombokTest() {
        step("Проверка авторизации ", () -> {
            restApiTestPage.authUser();
        });
    }


    @DisplayName("Безуспешная авторизация по API")
    @Test
    public void notLoginPojoTest() {
        step("Проверка авторизации ", () -> {
            restApiTestPage.failAuth();
        });
    }

    @DisplayName("API тест на наличие даты с использованием Groovy")
    @Test
    public void groovyTest() {
        step("Проверка авторизации ", () -> {
            restApiTestPage.groovyTest();
        });
    }
}


