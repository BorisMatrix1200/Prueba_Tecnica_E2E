package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//Clases que contienen los selectores (Target) de la interfaz de usuario.
//Se mantienen separados para centralizar el mantenimiento de localizadores.

public class FormularioCompra {

    public static final Target CHECKOUT = Target.the("Button Checkout").located(By.id("checkout"));
    public static final Target FIRSTNAME = Target.the("First name").located(By.id("first-name"));
    public static final Target LASTNAME = Target.the("Last name").located(By.id("last-name"));
    public static final Target POSTALCODE = Target.the("Postal Code").located(By.id("postal-code"));
    public static final Target BUTTONCONTINUE = Target.the("Button Continue").located(By.id("continue"));
    public static final Target BUTTONFINISH = Target.the("Button Finish").located(By.id("finish"));
    public static final Target BUYSUCCESSMESSAGE = Target.the("Buy Seccess Message").located(By.id("checkout_complete_container"));


}


