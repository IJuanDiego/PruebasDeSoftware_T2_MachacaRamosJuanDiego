package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/register";

    public static final Target FIRST_NAME_FIELD = Target.the("first name field").located(By.id("input-firstname"));

    public static final Target LAST_NAME_FIELD = Target.the("last name field").located(By.id("input-lastname"));

    public static final Target EMAIL_FIELD = Target.the("email field").located(By.id("input-email"));

    public static final Target TELEPHONE_FIELD = Target.the("telephone field").located(By.id("input-telephone"));

    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.name("password"));

    public static final Target PASSWORD_CONFIRM_FIELD = Target.the("confirm password field").located(By.name("confirm"));

    public static final Target PRIVACY_CHECKBOX = Target.the( "privacy checkbox").located(By.name("agree"));

    public static final Target CONTINUE_BUTTON = Target.the("login button").located(By.cssSelector("input[type='submit']"));

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .located(By.cssSelector("#content h1"));
}
