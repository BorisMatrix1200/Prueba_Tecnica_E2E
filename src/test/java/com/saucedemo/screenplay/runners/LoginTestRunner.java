package com.saucedemo.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
//Clases que ejecutan las pruebas. Normalmente anotadas con
//@RunWith(CucumberWithSerenity.class) y configuran la ubicación de features y stepdefinitions.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/login.feature",
    glue = "com.saucedemo.screenplay.stepdefinitions"
)

public class LoginTestRunner {}




