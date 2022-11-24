# Дипломный проект по автоматизации тестирования API на тестовом сайте <a target="_blank" href="https://reqres.in/">reqres.in</a>.

## :memo: Содержание:

- [Реализованные проверки](#boom-Реализованные-проверки)
- [Технологии](#classical_building-Технологии)
- [Сборка в Jenkins](#man_cook-Jenkins-job)
- [Allure отчет](#bar_chart-Allure-отчет)

## :boom: Реализованные проверки

- ✓ Регистрация пользователя
- ✓ Авторизация пользователя
- ✓ Авторизация без пароля
- ✓ Проверка наличия даты у item с использованием Groovy


## :classical_building: Технологии
<p align="center">
<img width="6%" title="Idea" src="images/logo/Idea.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/Junit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="REST Assured" src="images/logo/logo-transparent.png">
</p>

## :man_cook: Jenkins job
<img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>  <a target="_blank" href="https://jenkins.autotests.cloud/job/HW_12_REST-API/">Jenkins job</a>
<p align="center">
<a href=""><img src="images/screen/JenkinsApi.png" alt="Jenkins"/></a>
</p>


###  Локальный запуск:
```
gradle clean test
```

## :bar_chart: Allure-отчет
<img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/HW_12_REST-API/allure/">Allure report</a>
<p align="center">
<a href=""><img src="images/screen/AllureApi.png" alt="Jenkins"/></a>
</p>

## :bar_chart: Интеграция с Allure TestOps

<img src="images/logo/Allure_Ops.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://allure.autotests.cloud/project/1710/dashboards">Allure TestOps</a>
<p align="center">
<a href=""><img src="images/screen/dashboardApi.png" alt="Jenkins"/></a>
<a href=""><img src="images/screen/testCaseApi.png" alt="Jenkins"/></a>
</p>

##  Отчёт в telegram

<a href=""><img src="images/screen/Telegram.png" alt="Jenkins"/></a>