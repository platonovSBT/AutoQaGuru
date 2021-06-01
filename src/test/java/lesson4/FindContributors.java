package lesson4;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    @Test
    void firstCintributorShouldBeSolntsev(){
        //открыть страничку github
        open("https://github.com/selenide/selenide");
        //подвести мышку к первыому элемент в области Контрибуторов
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div").$("li").hover();
        //проверка : в появившемся окне (overlay)
        $$(".Popover-message").findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}