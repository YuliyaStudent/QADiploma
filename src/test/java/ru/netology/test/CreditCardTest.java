package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.CardData;
import ru.netology.data.SQLData;
import ru.netology.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
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
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getValidCardInfo());
        creditPage.successPayment();
        String actual = SQLData.getStatusCreditCard();
        assertEquals("APPROVED", actual);
    }

    @Test
    @DisplayName("Declined card number")
    public void declinedCardDataTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getDeclinedCardNumber());
        creditPage.failedPayment();
        String actual = SQLData.getStatusCreditCard();
        assertEquals("DECLINED", actual);

    }

    @Test
    @DisplayName("Latin letters in card number field")
    void latinLettersInCardNumberTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getLatinLettersInNumber());
        creditPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in card number field")
    void cyrillicLettersInCardNumberTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getCyrillicLettersInNumber());
        creditPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Empty card number field")
    void EmptyCardNumberFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getEmptyCardNumber());
        creditPage.emptyCardNotification();
    }

    @Test
    @DisplayName("Space in card number field")
    void SpaceButtonInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSpaceButtonInCardNumber());
        creditPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Symbols in card number field")
    void SymbolsInCardNumberTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSymbolsInCardNumber());
        creditPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Zero in card number field")
    void ZeroInCardNumberTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getZeroInCardNumber());
        creditPage.wrongFormatCardNotification();

    }

    @Test
    @DisplayName("Latin letters in Month field")
    void LatinLettersInMonthTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getLatinLettersInMonth());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in Month field")
    void CyrillicLettersInMonthTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getCyrillicLettersInMonth());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Zero numbers in Month field")
    void ZeroInMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getZeroNumbersInMonth());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Symbols in Month field")
    void SymbolsInMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSymbolsInMonth());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Space button in Month field")
    void SpaceButtonInMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSpaceButtonInMonth());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Empty Month field")
    void EmptyMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getEmptyFieldInMonth());
        creditPage.emptyMonthNotification();
    }

    @Test
    @DisplayName("Empty Year field")
    void EmptyYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getEmptyYearField());
        creditPage.emptyYearNotification();
    }

    @Test
    @DisplayName("Latin letters in year field")
    void LatinLettersInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getLatinLettersInYear());
        creditPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in year field")
    void CyrillicLettersInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getCyrillicLettersInYear());
        creditPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Space button in year field")
    void SpaceButtonInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSpaceButtonInYear());
        creditPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Symbols in year field")
    void SymbolsInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSymbolsInYearField());
        creditPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Faraway date in year field")
    void FarawayDateInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getFarAwayDate());
        creditPage.wrongYearNotification();
    }

    @Test
    @DisplayName("Past date in year field")
    void PastDateInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getPastDate());
        creditPage.expiredCardNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in owner field")
    void CyrillicLettersInOwnerFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getCyrillicLettersOwner());
        creditPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Empty owner field")
    void EmptyOwnerFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getEmptyOwnerField());
        creditPage.emptyOwnerNotification();
    }

    @Test
    @DisplayName("Symbols in owner field")
    void SymbolsInOwnerFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSymbolsInOwnerField());
        creditPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Space button in owner field")
    void SpaceButtonInOwnerFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSpaceInOwnerField());
        creditPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Numbers in owner field")
    void NumbersInOwnerFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getNumbersInOwnerField());
        creditPage.wrongOwnerNotification();
    }

    @Test
    @DisplayName("Cyrillic letters in CVC/CVV field")
    void CyrillicLettersInCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getCyrillicLettersInCVC());
        creditPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Latin letters in CVC/CVV field")
    void LatinLettersInCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getLatinLettersInCVCField());
        creditPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Empty CVC/CVV field")
    void EmptyCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getEmptyCVCField());
        creditPage.emptyCodeNotification();
    }

    @Test
    @DisplayName("Space button in CVC/CVV field")
    void SpaceButtonInCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getSpaceInCVCField());
        creditPage.wrongCodeNotification();
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
    void ZeroInCodeFieldTest() {
        var mainPage = new MainPage();
        var debitPage = mainPage.chooseDebitPayment();
        debitPage.fillForm(CardData.getZeroInCVCField());
        debitPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Fifteen numbers in card number field")
    void MinusOneNumberInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getMinusOneInCardNumber());
        creditPage.wrongFormatCardNotification();
    }

    @Test
    @DisplayName("Seventeen numbers in card number field")
    void PlusOneNumberInCardNumberFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getPlusOneInCardNumber());
        creditPage.failedPayment();
    }

    @Test
    @DisplayName("One number in Month field")
    void OneNumberInMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getMinusOneInMonthField());
        creditPage.wrongMonthNotification();
    }

    @Test
    @DisplayName("Three numbers in Month field")
    void ThreeNumbersInMonthFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getPlusOneInMonthField());
        creditPage.failedPayment();
    }

    @Test
    @DisplayName("One number in Year field")
    void OneNumberInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getMinusOneInYearField());
        creditPage.wrongYearFormatNotification();
    }

    @Test
    @DisplayName("Three numbers in Year field")
    void ThreeNumbersInYearFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getPlusOneInYearField());
        creditPage.failedPayment();
    }

    @Test
    @DisplayName("Two numbers in CVC/CVV field")
    void TwoNumbersInCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getMinusOneInCVCField());
        creditPage.wrongCodeNotification();
    }

    @Test
    @DisplayName("Four numbers in CVC/CVV field")
    void FourNumbersInCodeFieldTest() {
        var mainPage = new MainPage();
        var creditPage = mainPage.chooseBuyInCredit();
        creditPage.fillForm(CardData.getPlusOneInCVCField());
        creditPage.failedPayment();
    }
}
