package com.saucedemo.screenplay.tasks;


import com.saucedemo.screenplay.models.User;
import com.saucedemo.screenplay.ui.HomeProductos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Hit.*;
import static org.openqa.selenium.Keys.ESCAPE;
//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.
public class AgregarProductosCarrito implements Task {

    // Constructor vacío obligatorio para instrumented()
    public AgregarProductosCarrito() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Hit.the(ESCAPE).into(HomeProductos.ADDCART1),
                Click.on(HomeProductos.ADDCART1),
                Click.on(HomeProductos.ADDCART2),
                TomarScreenshot.con(BrowseTheWeb.as(actor).getDriver(), "Agrega productos al carrito")
        );

    }

    public static AgregarProductosCarrito enLaPagina(){
        return instrumented(AgregarProductosCarrito.class);
    }
}
