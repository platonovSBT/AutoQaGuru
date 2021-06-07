package lesson5;

import com.github.javafaker.Faker;
import lesson5.pageObject.UserInfo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormWithFakerTests extends InitTest {

    Faker faker = new Faker();
    UserInfo userInfo = new UserInfo();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile =  "1233211231",
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            subject1 = "Chemistry",
            hobby1 = "Sports",
            picture = "JMeter_00.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";
   /*
    Map<String, String> expectedData = new HashMap<String, String>() {{
            put("Student Name", firstName + " " + lastName);
            put("Student Email", email);
            put("Gender", gender);
            put("Mobile", gender);
            put("Date of Birth", dayOfBirth + " "+ monthOfBirth + "," + yearOfBirth);
            put("Subjects", subject1);
    }};

    */

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        userInfo.setMobile(mobile);
        userInfo.setEmail(email);
        userInfo.setGender(gender);
        userInfo.getGender().click();
        userInfo.setHobby(hobby1);
        userInfo.getHobby().click();
        userInfo.setAddress(currentAddress);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
        $("#subjectsInput").val(subject1).pressEnter();
        $("#uploadPicture").uploadFromClasspath("img/"+picture);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("[id=submit]").click();

        //Check data
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }

}
