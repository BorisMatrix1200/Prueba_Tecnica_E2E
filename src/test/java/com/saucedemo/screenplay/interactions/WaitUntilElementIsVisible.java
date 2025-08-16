package com.saucedemo.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
//Acciones atómicas reutilizables que un actor puede realizar, más pequeñas que una Task.
//Ejemplo: hacer scroll, esperar a que un elemento sea visible, presionar una tecla específica.

public class WaitUntilElementIsVisible implements Interaction {

    private final Target element;

    public WaitUntilElementIsVisible(Target element) {
        this.element = element;
    }

    public static WaitUntilElementIsVisible forElement(Target element) {
        return new WaitUntilElementIsVisible(element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(element, isVisible()).forNoMoreThan(10).seconds());
    }
}
