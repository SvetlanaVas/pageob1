package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import java.util.Random;
import static com.codeborne.selenide.Selenide.$;

public class CardChoicePage {
    private SelenideElement firstCardTransferButton = $("[data-test-id='action-deposit']");
    //private SelenideElement secondCardTransferButton = $("[data-test-id='action-deposit']").lastChild();
    private SelenideElement secondCardTransferButton = $("#root > div > ul > li:nth-child(2) > div > button");
    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public TransferPage choiceFirstCardForTransfer() {
        firstCardTransferButton.click();
        return new TransferPage();
    }

    public TransferPage choiceSecondCardForTransfer() {
        secondCardTransferButton.click();
        return new TransferPage();
    }

    public int checkFirstCardBalance() {
        String str = firstCardString.toString();
        return getCardBalance(str);
    }

    public int checkSecondCardBalance() {
        String str = secondCardString.toString();
        return getCardBalance(str);
    }
    public double getFirstCardBalanceIfAmountDoubleBeforeTransfer() {
        String str = firstCardString.toString();
        return getCardBalanceIfAmountDouble(str);
    }
    public double getSecondCardBalanceIfAmountDoubleBeforeTransfer() {
        String str = secondCardString.toString();
        return getCardBalanceIfAmountDouble(str);
    }
    @Value

    public static class MoneyTransfer {
        private String amount;
        private String cardNumber;
    }
    public static MoneyTransfer firstCardInfo() {
        CardChoicePage balance = new CardChoicePage();
        //int limit = balance.checkFirstCardBalance();
        //String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(Integer.toString(getRandomAmount(balance.checkFirstCardBalance())), "5559 0000 0000 0001");
    }
    public static MoneyTransfer secondCardInfo() {
        CardChoicePage balance = new CardChoicePage();
       // int limit = balance.checkSecondCardBalance();
        //String amount = Integer.toString(getRandomAmount(limit));
        return new MoneyTransfer(Integer.toString(getRandomAmount(balance.checkSecondCardBalance())), "5559 0000 0000 0002");
    }
    public static MoneyTransfer firstCardInfoWhenAmountDouble() {
        CardChoicePage balance = new CardChoicePage();
        //double limit = balance.getFirstCardBalanceIfAmountDoubleBeforeTransfer();
        //String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(Double.toString(getRandomDoubleAmount(balance.getFirstCardBalanceIfAmountDoubleBeforeTransfer())), "5559 0000 0000 0001");
    }
    public static MoneyTransfer secondCardInfoWhenAmountDouble() {
        CardChoicePage balance = new CardChoicePage();
        //double limit = balance.getSecondCardBalanceIfAmountDoubleBeforeTransfer();
        //String amount = Double.toString(getRandomDoubleAmount(limit));
        return new MoneyTransfer(Double.toString(getRandomDoubleAmount(balance.getSecondCardBalanceIfAmountDoubleBeforeTransfer())), "5559 0000 0000 0002");
    }


    public static int getRandomAmount(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static double getRandomDoubleAmount(double max) {
        Random random = new Random();
        return random.nextDouble();
    }

    public static int getCardBalance(String str) {
        int balance = 0;
        String[] cardList = str.split(" ");
         balance = Integer.parseInt(cardList[6]);
        return balance;
    }
    public static double getCardBalanceIfAmountDouble(String str) {
        double balance = 0;
        String[] cardList = str.split(" ");
         balance = Double.parseDouble(cardList[6]);
        return balance;
    }

}