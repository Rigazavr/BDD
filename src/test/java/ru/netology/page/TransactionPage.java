package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class TransactionPage {
    private final SelenideElement sumAmount = $("[data-test-id=amount] input");
    private final SelenideElement fromAccount = $("[data-test-id=from] input");
    private final SelenideElement clickReplenish = $("[data-test-id=action-transfer]");

    public void transferMoney(int amount, DataHelper.CardsInfo from) {
        sumAmount.setValue(valueOf(amount));
        fromAccount.setValue(String.valueOf(from));
        clickReplenish.click();
        new CardBalance();
    }

    public void errorLimit() {
        $(".notification__content").should(Condition.exactText("Ошибка"));
    }

    public void invalidCard() {
        $(".notification__content").should(Condition.text("Ошибка! Произошла ошибка"));
    }
}