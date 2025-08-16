package com.saucedemo.screenplay.tasks;


import com.saucedemo.screenplay.ui.FormularioCompra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.

public class CompletarFormularioCompra implements Task {



    public CompletarFormularioCompra() {

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(FormularioCompra.CHECKOUT),
                WaitUntil.the(FormularioCompra.FIRSTNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("Boris").into(FormularioCompra.FIRSTNAME),
                WaitUntil.the(FormularioCompra.LASTNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("Velez").into(FormularioCompra.LASTNAME),
                WaitUntil.the(FormularioCompra.POSTALCODE, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("050004").into(FormularioCompra.POSTALCODE),
                Click.on(FormularioCompra.BUTTONCONTINUE),
                Click.on(FormularioCompra.BUTTONFINISH),
                TomarScreenshot.con(BrowseTheWeb.as(actor).getDriver(), "Completa el formulario de compra")
        );

    }

    public static CompletarFormularioCompra enLaPagina(){
        return instrumented(CompletarFormularioCompra.class);
    }
}
