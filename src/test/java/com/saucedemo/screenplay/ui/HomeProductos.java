package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//Clases que contienen los selectores (Target) de la interfaz de usuario.
//Se mantienen separados para centralizar el mantenimiento de localizadores.

public class HomeProductos {

    public static final Target ADDCART1 = Target.the("Add to car product 1").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target ADDCART2 = Target.the("Add to car product 2").located(By.id("add-to-cart-sauce-labs-bike-light"));
    public static final Target SHOPPINGCART = Target.the("Button Shopping Cart").located(By.id("shopping_cart_container"));
}


