package lesson5.pageObject;

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
            address,
            subject1,
            state,
            city;

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

    public SelenideElement getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 =  $("#subjectsInput").val(subject1);
    }

    public SelenideElement getState() {
        return state;
    }

    public void setState(String state) {
        $("#state").click();
        this.state = $("#stateCity-wrapper").$(byText(state));
    }

    public SelenideElement getCity() {
        return city;
    }

    public void setCity(String city) {
        $("#city").click();
        this.city = $("#stateCity-wrapper").$(byText(city));
    }
}
