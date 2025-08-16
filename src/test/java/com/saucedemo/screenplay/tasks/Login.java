package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.models.User;
import com.saucedemo.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.Subject;

import static net.serenitybdd.screenplay.Tasks.instrumented;

//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.

public class Login implements Task {

    private final User user;

    public Login(User user) {
        this.user = user;
    }

    public static Login with(User user) {
        return instrumented(Login.class, user);
    }

    @Override
    @Subject("realiza login")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(LoginPage.USERNAME),
                Enter.theValue(user.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON),
                TomarScreenshot.con(BrowseTheWeb.as(actor).getDriver(), "Se ingresa usuario y contraseña correctamente")
        );
    }
}
