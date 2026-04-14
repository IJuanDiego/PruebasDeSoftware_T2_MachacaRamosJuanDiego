package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.*;

public class RegistrarseComo implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String password;

    public RegistrarseComo(String firstName, String lastName, String email, String telephone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;

    }

    public static Performable withCredentials(String firstName, String lastName, String email, String telephone,String password) {
        return Task.where("{0} registers with '"+email+"'", new RegistrarseComo(firstName, lastName, email, telephone,password));

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(RegistroPage.URL),
                Enter.theValue(firstName).into(RegistroPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(RegistroPage.LAST_NAME_FIELD),
                Enter.theValue(email).into(RegistroPage.EMAIL_FIELD),
                Enter.theValue(telephone).into(RegistroPage.TELEPHONE_FIELD),
                Enter.theValue(password).into(RegistroPage.PASSWORD_FIELD),
                Enter.theValue(password).into(RegistroPage.PASSWORD_CONFIRM_FIELD),
                Click.on(RegistroPage.PRIVACY_CHECKBOX),
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

}
