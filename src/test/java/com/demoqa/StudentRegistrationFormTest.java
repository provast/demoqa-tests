package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void testRegistration() {
        String formTitle = "Student Registration Form";
        String firstName = "Vadim";
        String lastName = "Astakhov";
        String email = "qwe123@ya.ru";
        String gender = "Male";
        String phone = "9203005000";
        String birthDay = "19";
        String birthMonth = "February";
        String birthYear = "1992";
        String subjects = "Computer Science";
        String hobbies1 = "Sports";
        String hobbies2 = "Reading";
        String file = "file.jpg";
        String currentAddress = "Moskva Kreml";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");

        $(".practice-form-wrapper h5").shouldHave(text(formTitle));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select")
                .$(byText(birthMonth)).click();
        $(".react-datepicker__year-select")
                .$(byText(birthYear)).click();
        $(".react-datepicker__month")
                .$(byText(birthDay)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies1)).click();
        $("#hobbiesWrapper").$(byText(hobbies2)).click();
        $("#uploadPicture")
                .uploadFromClasspath(file);
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper")
                .$(byText("Select State")).click();
        $("#stateCity-wrapper")
                .$(byText(state)).click();
        $("#stateCity-wrapper")
                .$(byText("Select City")).click();
        $("#stateCity-wrapper")
                .$(byText(city)).click();
        $("#submit").shouldBe(enabled).click();

        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $x("//tr[.//text()='Student Name']")
                .shouldHave(text(firstName + " " + lastName));
        $x("//tr[.//text()='Student Email']")
                .shouldHave(text(email));
        $x("//tr[.//text()='Gender']")
                .shouldHave(text(gender));
        $x("//tr[.//text()='Mobile']")
                .shouldHave(text(phone));
        $x("//tr[.//text()='Date of Birth']")
                .shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
        $x("//tr[.//text()='Subjects']")
                .shouldHave(text(subjects));
        $x("//tr[.//text()='Hobbies']")
                .shouldHave(text(hobbies1 + ", " + hobbies2));
        $x("//tr[.//text()='Picture']")
                .shouldHave(text(file));
        $x("//tr[.//text()='Address']")
                .shouldHave(text(currentAddress));
        $x("//tr[.//text()='State and City']")
                .shouldHave(text(state + " " + city));
    }
}
