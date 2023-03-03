package ru.netology.data;

import lombok.Value;

public class CardData {

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String name;
        private String cvcCvv;
    }

    public static CardInfo getValidCardInfo() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getLatinLettersInNumber() {
        return new CardInfo(DataHelper.latinLettersCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getDeclinedCardNumber() {
        return new CardInfo(DataHelper.getDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getEmptyCardNumber() {
        return new CardInfo(DataHelper.emptyCardField(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getCyrillicLettersInNumber() {
        return new CardInfo(DataHelper.cyrillicLettersCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSpaceButtonInCardNumber() {
        return new CardInfo(DataHelper.spaceButtonsInCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSymbolsInCardNumber() {
        return new CardInfo(DataHelper.symbolsInCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getZeroInCardNumber() {
        return new CardInfo(DataHelper.zeroCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());

    }

    public static CardInfo getLatinLettersInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.latinLettersInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getZeroNumbersInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.zeroMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSymbolsInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.symbolInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getCyrillicLettersInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.cyrillicLettersInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSpaceButtonInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.spaceButtonInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getEmptyFieldInMonth() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.emptyMonthField(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getLatinLettersInYear() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.latinLettersInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getEmptyYearField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.emptyYearField(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSpaceButtonInYear() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.spaceButtonInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getFarAwayDate() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.farAwayDate(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getCyrillicLettersInYear() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.cyrillicLettersInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getPastDate() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.pastDate(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSymbolsInYearField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.symbolInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getCyrillicLettersOwner() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.cyrillicLettersInOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getEmptyOwnerField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.emptyOwnerField(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSymbolsInOwnerField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.symbolsInOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getSpaceInOwnerField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.spaceButtonInOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getNumbersInOwnerField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.numberInOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getCyrillicLettersInCVC() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.cyrillicLettersInCode());
    }

    public static CardInfo getEmptyCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getEmptyCodeField());
    }

    public static CardInfo getLatinLettersInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.latinLettersInCode());
    }

    public static CardInfo getSpaceInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.spaceButtonInCode());
    }

    public static CardInfo getSymbolsInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.symbolsInCode());
    }

    public static CardInfo getZeroInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.zeroInCode());
    }


    public static CardInfo getMinusOneInCardNumber() {
        return new CardInfo(DataHelper.minusOneInCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getPlusOneInCardNumber() {
        return new CardInfo(DataHelper.plusOneInCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getMinusOneInMonthField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.minusOneInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getPlusOneInMonthField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.plusOneInMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getMinusOneInYearField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.minusOneInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getPlusOneInYearField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.plusOneInYear(),
                DataHelper.getValidOwner(),
                DataHelper.getValidCode());
    }

    public static CardInfo getMinusOneInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.minusOneInCode());
    }

    public static CardInfo getPlusOneInCVCField() {
        return new CardInfo(DataHelper.getApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidOwner(),
                DataHelper.plusOneInCode());
    }


}
