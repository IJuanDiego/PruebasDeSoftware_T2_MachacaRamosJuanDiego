package edu.pe.cibertec.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/";

    public static final Target SEARCH_INPUT = Target.the("search input").located(By.name("search"));

    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.cssSelector("button.btn.btn-default.btn-lg"));

    public static final Target PRODUCT_TITLES = Target.the("product titles").located(By.cssSelector(".product-thumb h4 a"));

    public static final Target NOT_RESULTS_MESSAGE = Target.the("no results message").located(By.cssSelector("#content p"));
}
