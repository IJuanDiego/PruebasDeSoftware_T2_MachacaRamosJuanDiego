package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Question;
import org.htmlunit.xpath.operations.Bool;

import java.util.List;
import java.util.stream.Collectors;

public class ResultadosDeBusqueda {

    public static Question<Boolean> searchProduct(String product) {
        return actor -> BusquedaPage.PRODUCT_TITLES
                .resolveAllFor(actor)
                .stream()
                .anyMatch(element -> element.getText().contains(product));
    }

    public static Question<String> errorMessage() {
        return actor -> BusquedaPage.NOT_RESULTS_MESSAGE.resolveFor(actor).getText();
    }

}
