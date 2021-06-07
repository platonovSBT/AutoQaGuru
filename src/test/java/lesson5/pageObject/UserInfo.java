package lesson5.pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserInfo {
    SelenideElement firstName,
            lastName,
            email,
            mobile,
            gender,
            hobby,
            address;

    public SelenideElement getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = $("#firstName").val(value);
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = $("#lastName").val(value);
    }

    public SelenideElement getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = $("#userEmail").val(value);
    }

    public SelenideElement getMobile() {
        return mobile;
    }

    public void setMobile(String value) {
        this.mobile = $("#userNumber").val(value);
    }

    public SelenideElement getGender() {
        return gender;
    }

    public void setGender(String value) {
        this.gender =  $("#genterWrapper").$(byText(value));
    }

    public SelenideElement getHobby() {
        return hobby;
    }

    public void setHobby(String value) {
        this.hobby =  $("#hobbiesWrapper").$(byText(value));
    }

    public SelenideElement getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address =   $("#currentAddress").val(value);
    }
}
