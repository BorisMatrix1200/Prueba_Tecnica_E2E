package com.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.

public class OpenThePage implements Task {

    private final String url;

    public OpenThePage(String url) {
        this.url = url;
    }

    public static OpenThePage at(String url) {
        return instrumented(OpenThePage.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
