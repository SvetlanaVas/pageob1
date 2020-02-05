package test;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import page.CardChoicePage;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.TransferPage;
import java.util.Locale;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferDashboard = new CardChoicePage();
        transferDashboard.choiceFirstCardForTransfer();

        val transferPage = new TransferPage();
        val cardInfo = DataHelper.secondCardInfo();
        transferPage.putMoneyCard(cardInfo);
    }
}
