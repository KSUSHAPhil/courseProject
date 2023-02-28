package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.mode.DBHelper;
import ru.netology.mode.DataHelper;


import ru.netology.web.page.OrderPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PaymentTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @BeforeEach
    void deletingDataFromTheDb() {
        DBHelper.deletingData();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    //Тест №1
    @Test
    public void shouldPaymentApprovedCard() {
        val cardInfo = new DataHelper().getValidCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getButtonSendARequest();
        paymentPage.getNotificationOk();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertEquals("APPROVED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }


    //Тест №2
    @Test
    public void shouldDeniedPurchaseDeclinedCard() {
        val cardInfo = new DataHelper().getInvalidCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationError();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertEquals("DECLINED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }

    //Тест №3
    @Test
    public void shouldDeniedPurchaseFakeCard() {
        val cardInfo = new DataHelper().getFakeCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationError();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertEquals("DECLINED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }

    //Тест №4
    @Test
    public void shouldRefuseToSubmitAnEmptyForm() {
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.clickButtonContinue();
        val paymentStatus = DBHelper.getPaymentStatus();
        val creditStatus = DBHelper.getCreditStatus();
        paymentPage.getErrorNotificationCardNumberRequired();
        paymentPage.getErrorNotificationMonthRequired();
        paymentPage.getErrorNotificationYearRequired();
        paymentPage.getErrorNotificationOwnerRequired();
        paymentPage.getErrorNotificationCVCRequired();
        assertNull(paymentStatus);
        assertNull(creditStatus);
    }

    //Тест №5
    @Test
    public void shouldDeniedPurchaseShortCard() {
        val cardInfo = new DataHelper().getShortCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationError();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertEquals("DECLINED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }

    //Тест №6
    @Test
    public void shouldDeniedPurchaseZeroCard() {
        val cardInfo = new DataHelper().getZeroCardInfo();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getNotificationError();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertEquals("DECLINED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }

    //Тест №7
    @Test
    public void shouldErrorApprovedCard00Month() {
        val cardInfo = new DataHelper().getInfo00Month();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatMonthField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }


    //Тест №8
    @Test
    public void shouldGetErrorApprovedCardEmptyMonth() {
        val cardInfo = new DataHelper().getInfoEmptyMonth();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationOwnerRequired();
        paymentPage.notGetErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationCVCRequired();
        paymentPage.notGetWrongFormatYearField();
        paymentPage.notGetWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №9
    @Test
    public void shouldErrorApprovedCardNonExistentMonth() {
        val cardInfo = new DataHelper().getInfoNonExistentMonth();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatMonthField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }


    //Тест №10
    @Test
    public void shouldErrorApprovedCardShortMonth() {
        val cardInfo = new DataHelper().getInfoShortMonth();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatMonthField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №11
    @Test
    public void shouldGetErrorApprovedCardShortYear() {
        val cardInfo = new DataHelper().getInfoShortYear();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationOwnerRequired();
        paymentPage.notGetErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationCVCRequired();
        paymentPage.notGetWrongFormatMonthField();
        paymentPage.notGetWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №12
    @Test
    public void shouldErrorApprovedCard00Year() {
        val cardInfo = new DataHelper().getInfo00Year();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongCardExpiredYearField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №13
    @Test
    public void shouldGetErrorApprovedCardEmptyYear() {
        val cardInfo = new DataHelper().getInfoEmptyYear();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationOwnerRequired();
        paymentPage.notGetErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationCVCRequired();
        paymentPage.notGetWrongFormatMonthField();
        paymentPage.notGetWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №14
    @Test
    public void shouldErrorApprovedCardPlus10Year() {
        val cardInfo = new DataHelper().getInfoYearPlus10();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatYearField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №15
    @Test
    public void shouldErrorApprovedCardLastYear() {
        val cardInfo = new DataHelper().getInfoLastYear();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongCardExpiredYearField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №16
    @Test
    public void shouldGetAnErrorApprovedCardNameInCyrillic() {
        val cardInfo = new DataHelper().getInfoNameInCyrillic();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №17
    @Test
    public void shouldGetAnErrorApprovedCardNameNonNumericNonAlphabetic() {
        val cardInfo = new DataHelper().getInfoNonNumericNonAlphabeticName();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №18
    @Test
    public void shouldPaymentApprovedCardOwnerNameInLatinWithAHyphen() {
        val cardInfo = new DataHelper().getInfoNameInLatinWithAHyphen();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getButtonSendARequest();
        paymentPage.getNotificationOk();
        val paymentStatus = DBHelper.getPaymentStatus();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertEquals("APPROVED", paymentStatus);
        assertEquals(transactionId, paymentID);
        assertNull(creditStatus);
    }

    //Тест №19
    @Test
    public void shouldGetAnErrorApprovedCardNameNumbers() {
        val cardInfo = new DataHelper().getInfoNumbersName();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getWrongFormatOwnerField();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №20
    @Test
    public void shouldGetErrorApprovedCardEmptyOwner() {
        val cardInfo = new DataHelper().getInfoEmptyOwner();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationOwnerRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationCVCRequired();
        paymentPage.notGetWrongFormatYearField();
        paymentPage.notGetWrongFormatMonthField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №21
    @Test
    public void shouldErrorApprovedCard2NumbersCVC() {
        val cardInfo = new DataHelper().getInfoWith2NumbersCVC();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationCVCRequired();
        val transactionId = DBHelper.getTransactionId();
        val paymentID = DBHelper.getPaymentId();
        val creditStatus = DBHelper.getCreditStatus();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №22
    @Test
    public void shouldGetErrorApprovedCardZeroCVC() {
        val cardInfo = new DataHelper().getInfoZeroCVC();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationCVCRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationOwnerRequired();
        paymentPage.notGetWrongFormatMonthField();
        paymentPage.notGetWrongFormatOwnerField();
        paymentPage.notGetWrongFormatYearField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

    //Тест №23
    @Test
    public void shouldGetErrorApprovedCardEmptyCVC() {
        val cardInfo = new DataHelper().getInfoEmptyCVC();
        val paymentPage = new OrderPage().getPaymentPage();
        paymentPage.fillingOutTheForm(cardInfo);
        paymentPage.getErrorNotificationCVCRequired();
        paymentPage.notGetErrorNotificationCardNumberRequired();
        paymentPage.notGetErrorNotificationMonthRequired();
        paymentPage.notGetErrorNotificationYearRequired();
        paymentPage.notGetErrorNotificationOwnerRequired();
        paymentPage.notGetWrongFormatMonthField();
        paymentPage.notGetWrongFormatOwnerField();
        paymentPage.notGetWrongFormatYearField();
        val transactionId = DBHelper.getTransactionId();
        val creditStatus = DBHelper.getCreditStatus();
        val paymentID = DBHelper.getPaymentId();
        assertNull(transactionId);
        assertNull(paymentID);
        assertNull(creditStatus);
    }

}
