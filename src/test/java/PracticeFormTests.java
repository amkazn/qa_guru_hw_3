import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
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


//        $("#stateCity-wrapper").$("#state").setValue("NCR");

//        System.out.println("********************************");
//        System.out.println($("#subjectsInput").exists());
//        System.out.println("********************************");




//        $("#dateOfBirthInput");



//
//        System.out.println("********************************");
//        System.out.println($("#dateOfBirthInput").val());
//        System.out.println($("#dateOfBirthInput").
//                $(byText("Choose Friday, January 26th, 2024")).exists());
//        System.out.println($("#dateOfBirthInput").getValue());
//        System.out.println("********************************");

    }
}
