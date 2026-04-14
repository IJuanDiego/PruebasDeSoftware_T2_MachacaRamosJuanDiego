package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ContadorDelCarrito;
import edu.pe.cibertec.tasks.AgregarAlCarrito;
import edu.pe.cibertec.ui.CarritoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CarritoStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor juan;

    @Before
    public void before(){
        juan = Actor.named("juan").whoCan(BrowseTheWeb.with(browser));
    }

    @When("the user adds the product {string} to the cart")
    public  void the_user_adds_the_product_to_the_cart(String productName){
         juan.attemptsTo(AgregarAlCarrito.withProduct(productName));
    }

    @Then("the cart should show {string}")
    public void the_cart_should_show(String messageCardButton){

        juan.attemptsTo(
                WaitUntil.the(CarritoPage.CART_WITH_ITEM,
                                WebElementStateMatchers.containsText("item"))
                        .forNoMoreThan(10).seconds()
        );

        juan.should(seeThat("cart with item", ContadorDelCarrito.withItem(), containsString(messageCardButton)));
    }

    @And("navigates to the cart")
    public void navigates_to_the_cart(){
        juan.attemptsTo(
                Click.on(CarritoPage.CART_BUTTON),
                WaitUntil.the(CarritoPage.BUTTON_VIEW_CART, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CarritoPage.BUTTON_VIEW_CART)
        );
    }

    @Then("the user should see the product {string} in the cart list")
    public void the_user_should_see_the_product_in_the_cart_list(String products) {
        juan.should(seeThat(ContadorDelCarrito.withProduct(products), is(true)));
    }
}
