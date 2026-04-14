package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/";
    public static final Target SEARCH_INPUT = Target.the("search input").located(By.name("search"));
    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.cssSelector("button.btn-default[type='button']"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button").located(By.xpath("//div[@class='product-thumb']//button[contains(@onclick,'cart.add')]"));
    public static final Target CART_WITH_ITEM = Target.the("cart counter").located(By.xpath("//div[@id='cart']/button"));


    public static final Target CART_BUTTON = Target.the("cart button").located(By.id("cart"));
    public static final Target BUTTON_VIEW_CART = Target.the("view cart option").located(By.xpath("//a[contains(@href,'route=checkout/cart')]"));
    public static final Target PRODUCTS_IN_CART = Target.the("products in cart").locatedBy("//div[@id='content']//table//tbody//tr//td[contains(@class,'text-left')]//a[contains(.,'{0}')]");

}
