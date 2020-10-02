import net.serenitybdd.junit.runners.SerenityRunner
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.actions.Open
import net.serenitybdd.screenplay.actions.SelectFromOptions
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Managed
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

@RunWith(SerenityRunner::class)
class PrimerTest {

    @Managed
    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){

        val emailAddress = Target.the("Email address")
            .located(By.cssSelector("input#email"))

        val orderReference = Target.the("Order reference")
            .located(By.cssSelector("input#id_order"))

        val message = Target.the("Message")
            .located(By.cssSelector("textarea#message"))

        val send = Target.the("Send")
            .located(By.cssSelector("button#submitMessage"))

        val subjectHeading = Target.the("Subject Heading")
                .located(By.cssSelector("id_contact"))

        val carlos = Actor.named("Carlos")

        carlos.can(BrowseTheWeb.with(webDriver))

        carlos.attemptsTo(
            Open.url("http://automationpractice.com/index.php?controller=contact"),
            Enter.theValue("robertsr1994@hotmail.com").into(emailAddress),
            Enter.theValue("Hola Mundo").into(message),
            Enter.theValue("1235462").into(orderReference),
            SelectFromOptions.byVisibleText("Customer service")
                    .from(subjectHeading),
            Click.on(send)
        )
    }
}