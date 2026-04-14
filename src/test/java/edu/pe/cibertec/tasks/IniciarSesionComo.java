package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class IniciarSesionComo implements Task {

    private final String email;
    private final String password;

    public IniciarSesionComo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Performable withCredentials(String email, String password) {
        return Task.where("{0} logs in with email '"+email+"' ",
                new IniciarSesionComo(email, password)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Open.url(LoginPage.URL),
                Enter.theValue(email).into(LoginPage.EMAIL_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD)
                //Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
