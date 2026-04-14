package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

    public static final Target EMAIL_FIELD = Target.the("email field").located(By.id("input-email"));

    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector("input[type='submit']"));

    public static final Target HEADER_NAME = Target.the("user name in header").located(By.cssSelector("#content h2, .col-sm-9 h2"));

    public static final Target ERROR_MESSAGE = Target.the("error message").located(By.cssSelector(".alert-danger"));
}


