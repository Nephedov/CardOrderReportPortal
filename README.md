Предусловия и окружение:
 - Установлен Docker Desktop. Версия 4.15.0.
 - Установлена подсистема WSL2.
 - Установлено приложение или преднастроено VPN подключение.
 - Установлена IntelliJ Idea Community Edition 2022.2.1
 - ОС - Windows 10 Home 64х.
 - JDK - openjdk version "11.0.15" 2022-04-19.
 - Google Chrome Версия 109.0.5414.76.

Подготовка, скачивание и установка. Шаги:
 1. Склонировать проект по ссылке https://github.com/Nephedov/CardOrderDeliveryChangeDate, взяв его как основу.
 2. Перейти по ссылке https://reportportal.io/docs/Deploy-with-Docker.
 3. С открывшейся страницы прейти по ссылке ![ReportPortal test automation analytics platform an](https://user-images.githubusercontent.com/111959547/214919724-3414f0d1-df55-419c-8301-79a4c549b449.jpg).
 4. Скопировать содержимое файла.![reportportal_docker-compose yml at master · report](https://user-images.githubusercontent.com/111959547/214931841-840cf6d4-f1f3-4b04-a974-e1bd7e70263e.jpg).
 5. Открыть свой проект в IDE.
 6. Добавить в корневую папку проекта файл 'docker-compose.yml' и вставить в него содержимое скопированного ранее файла.![CardOrderDeliveryReportPortal – docker-compose yml](https://user-images.githubusercontent.com/111959547/214931273-f40ead95-7fcf-4521-b50c-1a0e287ece20.png).
 7. Закомментировать для Unix систем и раскомментировать для Windows систем настройки 'volumes' в содержимом файла 'docker-compose.yml'.![CardOrderDeliveryReportPortal – docker-compose yml](https://user-images.githubusercontent.com/111959547/214929159-47a9e0ad-1636-44ae-94d2-f546a4a94d9e.png), ![CardOrderDeliveryReportPortal – docker-compose yml](https://user-images.githubusercontent.com/111959547/214929759-401c5fed-70af-4ff7-8434-02f3202526fb.png).
 8. Запустить Docker Desktop.
 9. Включить VPN.
 10. Открыть терминал и переместиться в корневую папку проекта.
 11. Ввести в терминал команду запуска контейнеров 'docker-compose -p reportportal up -d --force-recreate'.
 12. Дождаться успешного окончания загрузки и запуска контейнеров.
 13. Открыть в браузере адрес 'http://localhost:8080/'.
 14. Авторизоваться используя логин/пароль superadmin/erebus.
 15. В левом нижнем углу нажать на иконку и перейти в профиль. ![Report Portal - Google Chrome 2023-01-26 21 43 21](https://user-images.githubusercontent.com/111959547/214922651-88ed0630-5217-4656-b599-5b995e90ce9b.jpg).
 16. Скопировать содержимое обязательных настроек. ![Report Portal - Google Chrome 2023-01-26 21 45 56](https://user-images.githubusercontent.com/111959547/214923064-4659b298-63c2-40e1-b384-17a3388e27ea.jpg).
 17. Создать файл 'reportportal.properties', вставив в него скопированное ранее содержимое. Расположить файл в проекте по пути 'корневая папка проекта/src/test/resources/'.
 18. Перейти по ссылке https://github.com/netology-code/aqa-code/tree/master/reporting/selenide-reportportal.
 19. Скопировать файл 'log.xml' и папку 'META-INF/services' вместе с их содержимым. Расположить в проекте по пути 'корневая папка проекта/src/test/resources/'.
 20. Результат шагов 16-18 должен быть таким ![CardOrderDeliveryReportPortal 2023-01-26 21 57 54](https://user-images.githubusercontent.com/111959547/214925326-a5477dae-62e8-445c-ab5f-4c33cb013041.jpg).
 21. Перейти по ссылке https://github.com/netology-code/aqa-code/tree/master/reporting/selenide-reportportal.
 22. Скопировать папку 'util' вместе с её содержимым. И поместить себе в проект по пути 'корневая папка проекта/src/test/java/netology/'. ![CardOrderDeliveryReportPortal – ScreenShooterRepor](https://user-images.githubusercontent.com/111959547/214926351-139d3f0e-0b38-4ba9-8a7f-c65a918e41fb.jpg).
 23. Добавить в 'build.gradle':
      
      repositories { 
      - mavenLocal()
            }
          
      dependencies {
      - implementation 'com.epam.reportportal:agent-java-junit5:5.0.0'
      - implementation 'com.epam.reportportal:logger-java-logback:5.0.2'
      - implementation 'ch.qos.logback:logback-classic:1.2.3' 
          }
      
      test {
      - systemProperty 'junit.jupiter.extensions.autodetection.enabled', true
      - testLogging.showStandardStreams = true 
          }


