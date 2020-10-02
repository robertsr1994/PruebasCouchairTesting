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
class PrimerTestLogin {

    @Managed
    var webDriver: WebDriver? = null

    @Test
    fun navigateToContactPage(){

        val emailAddress = Target.the("Email address")
            .located(By.cssSelector("input#email"))

        val emailPassword = Target.the("Email Password")
                .located(By.cssSelector("input#passwd"))

        val sendBotton = Target.the("Send Boton")
                .located(By.cssSelector("button#SubmitLogin"))


        val carlos = Actor.named("Carlos")

        carlos.can(BrowseTheWeb.with(webDriver))

        carlos.attemptsTo(
            Open.url("http://automationpractice.com/index.php?controller=authentication&back=my-account"),
            Enter.theValue("robertsr1994@hotmail.com").into(emailAddress),
            Enter.theValue("123456789").into(emailPassword),
            Click.on(sendBotton)
        )
    }
}