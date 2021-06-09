package lesson5.pageObject;

import static com.codeborne.selenide.Selenide.$;

public class ButtonElement {
    public void clickSubmit() {
        $("[id=submit]").click();
    }
}
