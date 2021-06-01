package lesson4;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {
    @Test
    void shouldFindSelenideOnGitHub() {
        //открыть страничку гитхаб
        open("https://github.com");
        //ввести в поле поиска selenide
        //нажать enter
        $("[name=q]").setValue("selenide").pressEnter();
        //выбрать первый найденный из списка проект (кликнуть)
        SelenideElement firstRepositoryFound=$$("ul.repo-list li").first().$("a");
        firstRepositoryFound.click();
        //проверка в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
