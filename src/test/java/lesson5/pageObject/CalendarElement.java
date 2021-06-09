package lesson5.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarElement {

    public void setDayOfBirth(String selectYear, String selectMonth, String dayOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(selectYear);
        $(".react-datepicker__month-select").selectOption(selectMonth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
    }
}
