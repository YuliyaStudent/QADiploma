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
        SQLData.cleanDataBase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Valid data in all fields")
    void validDataAllFieldsTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getValidCardInfo());
        debitPage.successPayment();
        String actual = SQLData.getStatusDebitCard();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("Declined card number")
    void declinedCardDataTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getDeclinedCardNumber());
        debitPage.failedPayment();
        String actual = SQLData.getStatusDebitCard();
        assertEquals("DECLINED", actual);

    }

    @Test
    @DisplayName("Latin letters in card number field")
    void latinLettersInCardNumberTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getLatinLettersInNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in card number field")
    void cyrillicLettersInCardNumberTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getCyrillicLettersInNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Empty card number field")
    void EmptyCardNumberFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getEmptyCardNumber());
        debitPage.emptyCardNotification();
    }

    @Test
    @DisplayName("Space in card number field")
    void SpaceButtonInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSpaceButtonInCardNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Symbols in card number field")
    void SymbolsInCardNumberTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSymbolsInCardNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Zero in card number field")
    void ZeroInCardNumberTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getZeroInCardNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Latin letters in Month field")
    void LatinLettersInMonthTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getLatinLettersInMonth());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in Month field")
    void CyrillicLettersInMonthTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getCyrillicLettersInMonth());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Zero numbers in Month field")
    void ZeroInMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getZeroNumbersInMonth());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Symbols in Month field")
    void SymbolsInMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSymbolsInMonth());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Space button in Month field")
    void SpaceButtonInMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSpaceButtonInMonth());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Empty Month field")
    void EmptyMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getEmptyFieldInMonth());
        debitPage.emptyMonthNotification();
    }

    @Test
    @DisplayName("Empty Year field")
    void EmptyYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getEmptyYearField());
        debitPage.emptyYearNotification();
    }

    @Test
    @DisplayName("Latin letters in year field")
    void LatinLettersInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getLatinLettersInYear());
        debitPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in year field")
    void CyrillicLettersInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getCyrillicLettersInYear());
        debitPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Space button in year field")
    void SpaceButtonInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSpaceButtonInYear());
        debitPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Symbols in year field")
    void SymbolsInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSymbolsInYearField());
        debitPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Faraway date in year field")
    void FarawayDateInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getFarAwayDate());
        debitPage.wrongYearNotification();
    }

    @Test
    @DisplayName("Past date in year field")
    void PastDateInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getPastDate());
        debitPage.expiredCardNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in owner field")
    void CyrillicLettersInOwnerFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getCyrillicLettersOwner());
        debitPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Empty owner field")
    void EmptyOwnerFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getEmptyOwnerField());
        debitPage.emptyOwnerNotification();
    }

    @Test
    @DisplayName("Symbols in owner field")
    void SymbolsInOwnerFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSymbolsInOwnerField());
        debitPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Space button in owner field")
    void SpaceButtonInOwnerFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSpaceInOwnerField());
        debitPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Numbers in owner field")
    void NumbersInOwnerFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getNumbersInOwnerField());
        debitPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in CVC/CVV field")
    void CyrillicLettersInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getCyrillicLettersInCVC());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Latin letters in CVC/CVV field")
    void LatinLettersInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getLatinLettersInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Empty CVC/CVV field")
    void EmptyCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getEmptyCVCField());
        debitPage.emptyCodeNotification();
    }

    @Test
    @DisplayName("Space button in CVC/CVV field")
    void SpaceButtonInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSpaceInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Symbols in CVC/CVV field")
    void SymbolsInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getSymbolsInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Zero in CVC/CVV field")
    void ZeroInCodeTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getZeroInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Fifteen numbers in card number field")
    void MinusOneNumberInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getMinusOneInCardNumber());
        debitPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Seventeen numbers in card number field")
    void PlusOneNumberInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getPlusOneInCardNumber());
        debitPage.failedPayment();
    }

    @Test
    @DisplayName("One number in Month field")
    void OneNumberInMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getMinusOneInMonthField());
        debitPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Three numbers in Month field")
    void ThreeNumbersInMonthFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getPlusOneInMonthField());
        debitPage.failedPayment();
    }

    @Test
    @DisplayName("One number in Year field")
    void OneNumberInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getMinusOneInYearField());
        debitPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Three numbers in Year field")
    void ThreeNumbersInYearFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getPlusOneInYearField());
        debitPage.failedPayment();
    }

    @Test
    @DisplayName("Two numbers in CVC/CVV field")
    void TwoNumbersInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getMinusOneInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Four numbers in CVC/CVV field")
    void FourNumbersInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getPlusOneInCVCField());
        debitPage.failedPayment();
    }
}










