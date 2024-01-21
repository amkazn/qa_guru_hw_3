import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void CssXpathExamples(){
        $("[data-testid=email]").setValue("some text");
        $(by("data-testid", "email")).setValue("some text");
        $x("//*[@data-testid=email]").setValue("some text");

        //id
        $(byId("email")).setValue("some text");
        $(By.id("email")).setValue("some text");
        $("#email]").setValue("some text");

        //name
        


    }
}
