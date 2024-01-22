import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Sherlock");
        $("#lastName").setValue("Holmes");
        $("#userEmail").setValue("s@holmes.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--002").click();

        $("#subjectsInput")
                .setValue("Computer Science")
                .pressEnter();
        $("#subjectsInput")
                .setValue("Maths")
                .pressEnter();
        $("#subjectsInput")
                .setValue("Physics")
                .pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("pic.jpg");

        $("#currentAddress-wrapper")
                .$("#currentAddress")
                .setValue("Baker Street 221b");

        $("#stateCity-wrapper")
                .$("#state")
                .click();
        $("#stateCity-wrapper")
                .$("#state")
                .$(byText("NCR")).click();

        $("#stateCity-wrapper")
                .$("#city")
                .click();
        $("#stateCity-wrapper")
                .$("#city")
                .$(byText("Noida")).click();

        $("#submit").click();

        $(".modal-open")
                .shouldBe(visible);
        $(".table-responsive")
                .$(byText("Label"))
                .parent()
                .shouldHave(text("Values"));
        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .shouldHave(text("Sherlock Holmes"));
        $(".table-responsive")
                .$(byText("Student Email"))
                .parent()
                .shouldHave(text("s@holmes.com"));
        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .shouldHave(text("Male"));
        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .shouldHave(text("1234567890"));
        $(".table-responsive")
                .$(byText("Date of Birth"))
                .parent()
                .shouldHave(text("02 June,1990"));
        $(".table-responsive")
                .$(byText("Subjects"))
                .parent()
                .shouldHave(text("Computer Science, Maths, Physics"));
        $(".table-responsive")
                .$(byText("Hobbies"))
                .parent()
                .shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive")
                .$(byText("Picture"))
                .parent()
                .shouldHave(text("pic.jpg"));
        $(".table-responsive")
                .$(byText("Address"))
                .parent()
                .shouldHave(text("Baker Street 221b"));
        $(".table-responsive")
                .$(byText("State and City"))
                .parent()
                .shouldHave(text("NCR Noida"));
    }
}
