package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.tasks.IniciarSesionComo;
import edu.pe.cibertec.ui.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor juan;

    @Before
    public void setUp(){
        juan = Actor.named("juan").whoCan(BrowseTheWeb.with(browser));
        browser.manage().deleteAllCookies();
    }

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        juan.attemptsTo(Open.url(LoginPage.URL));
    }

    @When("the user enters email {string} and password {string}")
    public void the_user_enters_email_and_password(String email, String password) {
        juan.attemptsTo(IniciarSesionComo.withCredentials(email, password));
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        juan.attemptsTo(Click.on(LoginPage.LOGIN_BUTTON));
    }

    @Then("the user should see the name {string} in the page header")
    public void the_user_should_see_the_name_in_the_page_header(String name) {
        juan.should(seeThat("Nombre en header",
                        actor -> LoginPage.HEADER_NAME.resolveFor(actor).getText(),
                        containsString("My Account")));
    }

    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String message) {
        juan.should(seeThat("Error message", actor -> LoginPage.ERROR_MESSAGE.resolveFor(actor).getText(), containsString(message)));
    }

}
