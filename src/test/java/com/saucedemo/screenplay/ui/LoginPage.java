package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//Clases que contienen los selectores (Target) de la interfaz de usuario.
//Se mantienen separados para centralizar el mantenimiento de localizadores.

public class LoginPage {
    public static final Target USERNAME = Target.the("username").located(By.cssSelector("#user-name"));
    public static final Target PASSWORD = Target.the("password").located(By.cssSelector("#password"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector("#login-button"));
    public static final Target SUCCESS_MESSAGE = Target.the("success message").located(By.cssSelector("#menu_button_container"));
}
