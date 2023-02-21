package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement buyInCreditButton = $(byText("Купить в кредит"));

    public DebitPage chooseDebitPayment(){
        buyButton.click();
        return new DebitPage();
    }
    public CreditPage chooseBuyInCredit(){
        buyInCreditButton.click();
        return new CreditPage();
    }
}
