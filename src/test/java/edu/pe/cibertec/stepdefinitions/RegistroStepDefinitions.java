package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.tasks.RegistrarseComo;
import edu.pe.cibertec.ui.RegistroPage;
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
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RegistroStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor juan;

    @Before
    public void setUp() {
        juan = Actor.named("Juan").whoCan(BrowseTheWeb.with(browser));
    }

    @Given("the user navigates to the register page")
    public void the_user_navigates_to_the_register_page() {
        juan.attemptsTo(Open.url(RegistroPage.URL));
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void the_user_fills_the_form_with_first_name_last_name_email_phone_and_password(String firstName, String lastName, String email, String phone, String password) {
        juan.attemptsTo(RegistrarseComo.withCredentials(firstName, lastName, email, phone, password));
    }

    @And("accepts the privacy policy")
    public void accepts_the_privacy_policy() {
        juan.attemptsTo(Click.on(RegistroPage.PRIVACY_CHECKBOX));
    }

    @And("clicks on continue")
    public void clicks_on_continue() {
        juan.attemptsTo(Click.on(RegistroPage.CONTINUE_BUTTON));
    }

    @Then("the user should see the message {string}")
    public  void the_user_should_see_the_message(String message) {
        juan.attemptsTo(
                WaitUntil.the(RegistroPage.SUCCESS_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
