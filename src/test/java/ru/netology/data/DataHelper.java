package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }


    static Faker faker = new Faker(new Locale("en"));

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String latinLettersCardNumber() {
        return "hello hello hello hello";
    }

    public static String cyrillicLettersCardNumber() {
        return "иван иван иван иван";
    }

    public static String symbolsInCardNumber() {
        return "4444 4$44 4444 4441";
    }

    public static String spaceButtonsInCardNumber() {
        return "                ";
    }

    public static String emptyCardField() {
        return "";
    }

    public static String zeroCardNumber() {
        return "0000 0000 0000 0000 0000";
    }

    public static String getValidMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String latinLettersInMonth() {
        return "ив";
    }

    public static String zeroMonth() {
        return "00";
    }

    public static String symbolInMonth() {
        return "??";
    }

    public static String cyrillicLettersInMonth() {
        return "фф";
    }

    public static String spaceButtonInMonth() {
        return "  ";
    }

    public static String emptyMonthField() {
        return "";
    }

    public static String emptyYearField() {
        return "";
    }

    public static String getValidYear() {
        return LocalDate.now().plusYears(2).format((DateTimeFormatter.ofPattern("yy")));
    }

    public static String latinLettersInYear() {
        return "ww";
    }

    public static String spaceButtonInYear() {
        return "  ";
    }

    public static String farAwayDate() {
        return LocalDate.now().plusYears(50).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String cyrillicLettersInYear() {
        return "ау";
    }

    public static String pastDate() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String symbolInYear() {
        return "??";
    }

    public static String getValidOwner() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String cyrillicLettersInOwner() {
        return "Иван Иванов";
    }

    public static String emptyOwnerField() {
        return "";
    }

    public static String symbolsInOwner() {
        return "??? &&&&&";
    }

    public static String spaceButtonInOwner() {
        return "        ";
    }

    public static String numberInOwner() {
        return "1234 5678";
    }

    public static String getValidCode() {
        return String.valueOf(faker.number().numberBetween(001, 998));
    }

    public static String cyrillicLettersInCode() {
        return "год";
    }

    public static String getEmptyCodeField() {
        return "";
    }

    public static String latinLettersInCode() {
        return "pas";
    }

    public static String spaceButtonInCode() {
        return "pas";
    }

    public static String symbolsInCode() {
        return "...";
    }

    public static String zeroInCode() {
        return "000";
    }

    public static String minusOneInCardNumber() {
        return "444444444444444";
    }

    public static String plusOneInCardNumber() {
        return "44444444444444411";
    }

    public static String minusOneInMonth() {
        return "7";
    }

    public static String plusOneInMonth() {
        return "007";
    }

    public static String minusOneInYear() {
        return "5";
    }

    public static String plusOneInYear() {
        return "025";
    }

    public static String minusOneInCode() {
        return "02";
    }

    public static String plusOneInCode() {
        return "0202";
    }

}