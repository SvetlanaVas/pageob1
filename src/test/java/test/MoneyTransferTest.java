package test;
import data.DataHelper;
import page.CardChoicePage;
import lombok.*;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.TransferPage;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyFromSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        String secondCardInfo= CardChoicePage.getSecondCardNumber();

        String amount = CardChoicePage.getTransferAmount(secondCardInfo);
        val cardInfo = DataHelper.secondCardInfo();
        CardChoicePage.choiceFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

    }
    @Test
    void checkSecondCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        val cardNumber = new CardChoicePage();
        String firstCardNumber = CardChoicePage.getfirstCardNumber();

        String amount = CardChoicePage.getTransferAmount(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();
        String secondCardNumberBeforeTransfer = CardChoicePage.getSecondCardNumber();

        int expected = (CardChoicePage.getCardBalance(secondCardNumberBeforeTransfer) + Integer.parseInt(amount));
        CardChoicePage.choiceSecondCardForTransfer();

        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
        String secondCardNumberAfterTransfer = CardChoicePage.getSecondCardNumber();
        int actual = CardChoicePage.getCardBalance(secondCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
    @Test
    void shouldTransferMoneyFromFirstCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        String firstCardInfo= CardChoicePage.getfirstCardNumber();

        String amount = CardChoicePage.getTransferAmount(firstCardInfo);
        val cardInfo = DataHelper.firstCardInfo();
        CardChoicePage.choiceSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

    }

    @Test
    void checkFirstCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        String secondCardNumber = CardChoicePage.getSecondCardNumber();
        String amount = CardChoicePage.getTransferAmount(secondCardNumber);
        val cardInfo = DataHelper.secondCardInfo();

        String firstCardNumberBeforeTransfer = CardChoicePage.getfirstCardNumber();
        int expected = (CardChoicePage.getCardBalance(firstCardNumberBeforeTransfer)+ Integer.parseInt(amount));

        CardChoicePage.choiceFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        String firstCardNumberAfterTransfer = CardChoicePage.getfirstCardNumber();
        int actual = CardChoicePage.getCardBalance(firstCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }

      @Test
   void shouldTransferMoneyFromSecondCardIfAmountDouble() {
       val loginPage = new LoginPage();
       loginPage.openLoginPage();
       val authInfo = DataHelper.getAuthInfo();
       val verificationPage = loginPage.validLogin(authInfo);
       val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
       verificationPage.validVerify(verificationCode);

       val transferPage = new TransferPage();
       String secondCardNumber = CardChoicePage.getSecondCardNumber();
       String amount = CardChoicePage.getTransferAmountWhenDouble(secondCardNumber);

       val cardInfo = DataHelper.secondCardInfo();
       CardChoicePage.choiceFirstCardForTransfer();
       transferPage.putTransferAmount(amount);
       transferPage.putMoneyCard(cardInfo);
   }
    @Test
    void checkFirstCardBalanceIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferPage = new TransferPage();
        String secondCardNumber = CardChoicePage.getSecondCardNumber();

        String amount = CardChoicePage.getTransferAmountWhenDouble(secondCardNumber);
        val cardInfo = DataHelper.secondCardInfo();
        String firstCardNumberBeforeTransfer = CardChoicePage.getfirstCardNumber();

        double expected = (CardChoicePage.getCardBalanceIfAmountDouble(firstCardNumberBeforeTransfer) + Double.parseDouble(amount));
        CardChoicePage.choiceFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);

        String firstCardNumberAfterTransfer = CardChoicePage.getfirstCardNumber();
        double actual = CardChoicePage.getCardBalanceIfAmountDouble(firstCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
}


