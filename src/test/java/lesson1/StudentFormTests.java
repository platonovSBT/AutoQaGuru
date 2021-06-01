package lesson1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTests {
    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Boris");
        $("[id=lastName]").setValue("Elzin");
        $("[id=userEmail]").setValue("usermail@mail.ru");
        $("[id=gender-radio-1]").parent().click();
        $("[id=userNumber]").setValue("1321321321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("December");
        $("[aria-label='Choose Thursday, December 26th, 1991']").click();
        $("[id=subjectsInput]").setValue("com").pressEnter();
        $("[id=hobbies-checkbox-2]").parent().click();
        $("[id=currentAddress]").setValue("currentAddress");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Del").pressEnter();
        $("[id=submit]").click();

        //Check data
        $(".table-responsive").shouldHave(text("Boris Elzin"), text("usermail@mail.ru"),
                text("Male"), text("1321321321"), text("26 December,1991"), text("Computer Science"),
                text("Reading"), text("currentAddress"),
                text("NCR Delhi"));
    }

}
