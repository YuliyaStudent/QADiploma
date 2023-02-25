package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.CardData;
import ru.netology.data.SQLData;
import ru.netology.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardTest {


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SQLData.cleanDataBase();
    }

    @Test
    @DisplayName("Valid data in all fields")
    public void validDataAllFieldsTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getValidCardInfo());
        debitPage.successPayment();
        String actual = SQLData.getStatusDebitCard();
        assertEquals("APPROVED",actual);
    }

    @Test
    @DisplayName("Declined card number")
    public void declinedCardDataTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getDeclinedCardNumber());
        debitPage.failedPayment();
        var actual = SQLData.getStatusDebitCard();
        assertEquals("DECLINED", actual);

    }
}






