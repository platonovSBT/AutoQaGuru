package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentFormTests {
    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("firstName1");
        $("[id=lastName]").setValue("lastName1");
        $("[id=userEmail]").setValue("usermail@mail.ru");
        $("[id=gender-radio-1]").parent().click();
        $("[id=userNumber]").setValue("1321321321");
        $("[id=currentAddress]").setValue("currentAddress");
        $("[id=submit]").click();

    }
}
