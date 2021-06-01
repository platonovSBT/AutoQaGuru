package lesson4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

public class HW_4 {
    @Test
    void workWithGithubTest() {
        //открыть гитхаб
        open("https://github.com");
        //в строке поиска найти Selenide
        $("[name=q]").setValue("selenide").pressEnter();
        //выбрать первый проект из списка
        $(".f4.text-normal").$("a").click();
        //перейти на вкладку WIKI
        $("[data-content=Wiki]").click();
        //проверка , что в списке страниц есть страница SoftAssertions
        $(".Box-row.wiki-more-pages-link button").click();
        $(".Box-row.wiki-more-pages a").shouldHave(Condition.text("SoftAssertions"));
        //Открыть страницу SoftAssertions
        $(".Box-row.wiki-more-pages a").click();
        // проверка, что внутри есть пример кода для JUnit5
        $$(".markdown-body li").shouldHave(itemWithText("Using JUnit5 extend test class:"));

    }

    @Test
    void additionalTaskTest() {
        // ***3. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(5000);
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        sleep(5000);
        $("#column-a header").shouldHave(Condition.text("B"));
        // - Проверьте, что прямоугольники действительно поменялись
        //P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест,
        // если использовать её вместо actions()
    }
}
