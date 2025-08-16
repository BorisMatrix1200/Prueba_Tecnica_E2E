package com.saucedemo.screenplay.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnlineCast;
//Implementación en Java de los pasos definidos en Gherkin (Given, When, Then).
//Aquí se llama a tasks, interactions y questions.
public class Hooks {

    @Before
    public void setStage() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

}
