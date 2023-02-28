package ru.netology.mode;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {

    private Faker faker = new Faker();

    private String getValidCardNumber() {
        return "1111 2222 3333 4444";
    }

    private String getInvalidCardNumber() {
        return "5555 6666 7777 8888";
    }

    private String getFakeCardNumber() {
        return "1111 1111 1111 1111";
    }

    private String getShortCardNumber() {
        return "1111 1111 1111 111";
    }

    private String getZeroCardNumber() {
        return "0000 0000 0000 0000";
    }


    public String generateDate(int plusMonth, String formatPattern) {
        return LocalDate.now().plusMonths(plusMonth).format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public String generateYear(int plusYear, String formatPattern) {
        return LocalDate.now().plusYears(plusYear).format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public String getValidDate() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 60);
        String date = generateDate(randomNumber, "MM.yy");
        return date;
    }

    public String generateOwner() {
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        return owner;
    }

    public String generateCVC() {
        return (faker.numerify("###"));
    }

    public String generateCVC2Numbers() {
        return (faker.numerify("##"));
    }

    @Value
    public static class CardInfo {
        private String number;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public CardInfo getValidCardInfo() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC());
    }

    public CardInfo getInfoEmptyYear() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), "", generateOwner(), generateCVC());
    }

    public CardInfo getInfoEmptyMonth() {
        return new CardInfo(getValidCardNumber(), "", getValidDate().substring(3), generateOwner(), generateCVC());
    }

    public CardInfo getInfoEmptyOwner() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), "", generateCVC());
    }

    public CardInfo getInfoEmptyCVC() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), "");
    }

    public CardInfo getInfoZeroCVC() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), "000");
    }

    public CardInfo getInfoNameInLatinWithAHyphen() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), "Mihail Petrov-Vodkin", generateCVC());
    }

    public CardInfo getInfoNameInCyrillic() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), "Иванов Иван", generateCVC());
    }

    public CardInfo getInfoNumbersName() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), "345126586", generateCVC());
    }

    public CardInfo getInfoNonNumericNonAlphabeticName() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), "+*-=№?", generateCVC());
    }

    public CardInfo getInfoNonExistentMonth() {
        return new CardInfo(getValidCardNumber(), "22", generateDate(0, "yy"), generateOwner(), generateCVC());
    }

    public CardInfo getInfo00Month() {
        return new CardInfo(getValidCardNumber(), "00", generateDate(0, "yy"), generateOwner(), generateCVC());
    }

    public CardInfo getInfoShortMonth() {
        return new CardInfo(getValidCardNumber(), "1", generateDate(12, "yy"), generateOwner(), generateCVC());
    }


    public CardInfo getInfoLastYear() {
        return new CardInfo(getValidCardNumber(), generateDate(-12, "MM"), generateDate(-12, "yy"), generateOwner(), generateCVC());
    }

    public CardInfo getInfo00Year() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), "00", generateOwner(), generateCVC());
    }

    public CardInfo getInfoShortYear() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), "2", generateOwner(), generateCVC());
    }

    public CardInfo getInfoYearPlus10() {
        return new CardInfo(getValidCardNumber(), generateYear(10, "yy"), generateDate(72, "yy"), generateOwner(), generateCVC());
    }

    public CardInfo getInfoWith2NumbersCVC() {
        return new CardInfo(getValidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC2Numbers());
    }


    public CardInfo getInvalidCardInfo() {
        return new CardInfo(getInvalidCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC());
    }

    public CardInfo getFakeCardInfo() {
        return new CardInfo(getFakeCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC());
    }

    public CardInfo getShortCardInfo() {
        return new CardInfo(getShortCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC());
    }

    public CardInfo getZeroCardInfo() {
        return new CardInfo(getZeroCardNumber(), getValidDate().substring(0, 2), getValidDate().substring(3), generateOwner(), generateCVC());
    }


}
