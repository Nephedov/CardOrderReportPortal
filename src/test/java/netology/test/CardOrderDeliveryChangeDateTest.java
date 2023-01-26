package netology.test;

import com.codeborne.selenide.Condition;
import netology.data.ClearField;
import netology.data.DataGenerator;
import netology.util.ScreenShooterReportPortalExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static netology.util.LoggingUtils.logInfo;

@ExtendWith({ScreenShooterReportPortalExtension.class})
public class CardOrderDeliveryChangeDateTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    void positiveRegistrationTest() {

        DataGenerator.UserInfo user = DataGenerator.Registration.generateUser("ru");
        String planningDate = DataGenerator.generateDate(3);
        String newPlanningDate = DataGenerator.generateDate(10);

        $("[data-test-id='city'] input").setValue(user.getCity());
        logInfo("В поле ввода введен город " + user.getCity());
        $("[data-test-id='date'] input").sendKeys(ClearField.deleteString);
        logInfo("Поле ввода даты очищено");
        $("[data-test-id='date'] input").setValue(planningDate);
        logInfo("В поле ввода введена дата " + planningDate);
        $("[data-test-id='name'] input").setValue(user.getName());
        logInfo("В поле ввода введено имя " + user.getName());
        $("[data-test-id='phone'] input").setValue(user.getPhone());
        logInfo("В поле введен номер телефона " + user.getPhone());
        $(".checkbox__box").click();
        logInfo("Выбран чекбокс согласия на обработку ");
        $x("//span[contains(text(),'Запланировать')]").click();
        logInfo("Нажата кнопка 'Запланировать' ");
        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(Condition.text("Встреча успешно запланирована на " + planningDate));
        logInfo("Выведено сообщение с текстом 'Встреча успешно запланирована на ' " + planningDate);

        $("[data-test-id='city'] input").setValue(ClearField.deleteString);
        logInfo("Поле ввода города очищено");
        $("[data-test-id='city'] input").setValue(user.getCity());
        logInfo("В поле ввода введен город " + user.getCity());
        $("[data-test-id='date'] input").sendKeys(ClearField.deleteString);
        logInfo("Поле ввода даты очищено");
        $("[data-test-id='date'] input").setValue(newPlanningDate);
        logInfo("В поле ввода введена дата " + newPlanningDate);
        $("[data-test-id='name'] input").setValue(ClearField.deleteString);
        logInfo("Поле ввода имени очищено");
        $("[data-test-id='name'] input").setValue(user.getName());
        logInfo("В поле ввода введено имя " + user.getName());
        $("[data-test-id='phone'] input").setValue(ClearField.deleteString);
        logInfo("Поле ввода телефона очищено");
        $("[data-test-id='phone'] input").setValue(user.getPhone());
        logInfo("В поле введен номер телефона " + user.getPhone());
        $x("//span[contains(text(),'Запланировать')]").click();
        logInfo("Нажата кнопка 'Запланировать' ");
        $x(".//div [contains(text(), 'У вас уже запланирована встреча на другую дату. Перепланировать?')]")
                .shouldBe(visible, Duration.ofSeconds(15));
        logInfo("Выведено сообщение с текстом 'У вас уже запланирована встреча на другую дату. Перепланировать?' ");
        $x(".//span[contains(text(), 'Перепланировать')]").click();
        logInfo("Нажата кнопка 'Перепланировать' ");
        $("[data-test-id='success-notification']").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(Condition.text("Встреча успешно запланирована на " + newPlanningDate));
        logInfo("Выведено сообщение с текстом 'Встреча успешно запланирована на ' " + newPlanningDate);


    }
}




