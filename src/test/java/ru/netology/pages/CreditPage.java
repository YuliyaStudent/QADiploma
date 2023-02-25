package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.CardData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private SelenideElement cardField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $ ("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $(By.xpath("//span[text()='Владелец']/..//input"));
    private SelenideElement codeField = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));

    private SelenideElement wrongFormatCard = $(byText("Неверный формат"));
    private SelenideElement emptyCardField = $(byText("поле обязательно для заполнения"));
    private SelenideElement wrongMonth = $(byText("Неверный формат"));
    private SelenideElement emptyMonthField = $(byText("поле обязательно для заполнения"));
    private SelenideElement wrongYearFormat = $(byText("Неверный формат"));
    private SelenideElement emptyYearField = $(byText("поле обязательно для заполнения"));
    private SelenideElement wrongYear = $(byText("Неверно указан срок действия карты"));
    private SelenideElement expiredCard = $(byText("Истёк срок действия карты"));
    private SelenideElement wrongOwner = $(byText("Неверный формат"));
    private SelenideElement emptyOwnerField = $(byText("поле обязательно для заполнения"));
    private SelenideElement wrongCode = $(byText("Неверный формат"));
    private SelenideElement emptyCodeField = $(byText("поле обязательно для заполнения"));

    private SelenideElement successNotification = $(byText("Успешно"));
    private SelenideElement failNotification = $(byText("Ошибка"));

    public void wrongFormatCardNotification(){
        wrongFormatCard.shouldBe(visible);
    }
    public void emptyCardNotification(){
        emptyCardField.shouldBe(visible);
    }
    public void wrongMonthNotification(){
        wrongMonth.shouldBe(visible);
    }
    public void  emptyMonthNotification(){
        emptyMonthField.shouldBe(visible);
    }
    public void wrongYearFormatNotification(){
        wrongYearFormat.shouldBe(visible);
    }
    public void emptyYearNotification(){
        emptyYearField.shouldBe(visible);
    }
    public void wrongYearNotification(){
        wrongYear.shouldBe(visible);
    }
    public void expiredCardNotification(){
        expiredCard.shouldBe(visible);
    }
    public void wrongOwnerNotification(){
        wrongOwner.shouldBe(visible);
    }
    public void emptyOwnerNotification(){
        emptyOwnerField.shouldBe(visible);
    }
    public void wrongCodeNotification(){
        wrongCode.shouldBe(visible);
    }
    public void emptyCodeNotification (){
        emptyCodeField.shouldBe(visible);
    }
    public void successPayment(){
        successNotification.shouldBe(hidden);
    }
    public void failedPayment(){
        failNotification.shouldBe(hidden);
    }
    public void fillForm(CardData.CardInfo cardInfo){
        cardField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        ownerField.setValue(cardInfo.getName());
        codeField.setValue(cardInfo.getCvcCvv());
        continueButton.click();

    }
}