package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarProducto implements Task {

    private final String product;

    public BuscarProducto(String product) {
        this.product = product;
    }

    public static Performable withProduct(String producto) {
        return Task.where("{0} search for product " + producto,
                new BuscarProducto(producto)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(BusquedaPage.SEARCH_INPUT),
                Click.on(BusquedaPage.SEARCH_BUTTON)
        );
    }

}
