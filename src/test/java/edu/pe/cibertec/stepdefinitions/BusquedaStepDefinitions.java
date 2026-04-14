package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.tasks.BuscarProducto;
import edu.pe.cibertec.ui.BusquedaPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.fluentlenium.core.search.Search;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor juan;

    @Before
    public void setUp() {
        juan = Actor.named("Juan").whoCan(BrowseTheWeb.with(browser));
        browser.manage().deleteAllCookies();
    }

    @Given("the user is on the OpenCart home page")
    public void the_user_is_on_the_OpenCart_home_page() {
        juan.attemptsTo(Open.url(BusquedaPage.URL));
    }

    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String product) {
        juan.attemptsTo(BuscarProducto.withProduct(product));
    }

    @Then("the user should see at least one result with the name {string}")
    public void the_user_should_see_at_least_one_result_with_name(String product) {
        juan.should(seeThat("search product", ResultadosDeBusqueda.searchProduct(product), is(true)));
    }

}
