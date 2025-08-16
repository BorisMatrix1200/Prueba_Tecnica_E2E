package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.FormularioCompra;
import com.saucedemo.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
//Consultas que realiza el actor para verificar el estado del sistema. Devuelven un valor que se usará en las aserciones.
//Ejemplo: obtener el texto de un elemento, contar ítems en un carrito.
public class BuySuccessMessage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return FormularioCompra.BUYSUCCESSMESSAGE.resolveFor(actor).isVisible();

    }

    public static LoginSuccessMessage isVisible() {
        return new LoginSuccessMessage();
    }
}
