package com.saucedemo.screenplay.tasks;


import com.saucedemo.screenplay.ui.HomeProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.

public class VisualizarCarrito implements Task {

    // Constructor vacío obligatorio para instrumented()
    public VisualizarCarrito() {
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(HomeProductos.SHOPPINGCART),
                TomarScreenshot.con(BrowseTheWeb.as(actor).getDriver(), "Agrega productos al carrito")
        );

    }

    public static VisualizarCarrito enLaPagina(){
        return instrumented(VisualizarCarrito.class);
    }
}
