package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContadorDelCarrito {

    public static Question<String> withItem() {
        return actor -> CarritoPage.CART_WITH_ITEM.resolveFor(actor).getText();
    }

    public static Question<Boolean> withProduct(String product) {
        return actor -> {
            WaitUntil.the(CarritoPage.PRODUCTS_IN_CART.of(product), isVisible())
                    .forNoMoreThan(10).seconds()
                    .performAs(actor);
            return CarritoPage.PRODUCTS_IN_CART.of(product).resolveFor(actor).isVisible();
        };

    }
}
