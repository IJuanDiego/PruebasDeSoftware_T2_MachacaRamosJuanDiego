package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarrito implements Task {

    private final String product;

    public AgregarAlCarrito(String product) {
        this.product = product;
    }

    public static Performable withProduct(String product) {
        return Task.where("{0} adds product '" + product + "' to the cart",
                new AgregarAlCarrito(product)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(CarritoPage.SEARCH_INPUT),
                Click.on(CarritoPage.SEARCH_BUTTON),
                Click.on(CarritoPage.ADD_TO_CART_BUTTON)
        );
    }

}
