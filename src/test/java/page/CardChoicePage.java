package page;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class CardChoicePage {
    private SelenideElement firstCardTransferButton = $("[data-test-id='action-deposit']");
    private SelenideElement secondCardTransferButton = $("[data-test-id='action-deposit']").lastChild();
    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public TransferPage choiceFirstCardForTransfer(){
        firstCardTransferButton.click();
        return new TransferPage();
    }
    public TransferPage choiceSecondCardForTransfer(){
        secondCardTransferButton.click();
        return new TransferPage();
    }
    public int checkFirstCardBalance(){
        int balance = 0;
        String str = firstCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++){
            balance = Integer.parseInt(сardList[6]);
        }
        return balance;
    }
    public int checkSecondCardBalance(){
        int balance = 0;
        String str = secondCardString.toString();
        String[] cardList = str.split(" ");
        for (int i = 0; i < cardList.length; i++){
            balance = Integer.parseInt(cardList[6]);
        }
        return balance;
    }
}