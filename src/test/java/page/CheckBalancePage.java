package page;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
public class CheckBalancePage {
    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    public DashboardPage firstCardBalanceShouldBeLess() {
        int newBalance = 0;
        String str = firstCardString.toString();
        String[] сardList = str.split(" ");
        for (int i = 0; i < сardList.length; i++) {
            newBalance = Integer.parseInt(сardList[6]);
        }

        CardChoicePage balance = new CardChoicePage();
        int limitBalance = balance.checkFirstCardBalance();
        if (newBalance < limitBalance) {
        }
        return new DashboardPage();
    }
}