package com.saucedemo.screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//Acciones de alto nivel que un actor realiza para cumplir un objetivo. Se construyen combinando interactions.
//Ejemplo: "Login" podría incluir abrir la página, ingresar usuario y contraseña, y hacer clic en login.

public class TomarScreenshot implements Task {

    private final WebDriver driver;
    private final String nombreArchivo;

    public TomarScreenshot(WebDriver driver, String nombreArchivo) {
        this.driver = driver;
        this.nombreArchivo = nombreArchivo;
    }

    @Step("{0} toma una captura de pantalla")
    @Override
    public <T extends Actor> void performAs(T actor) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String rutaDestino = "src/test/resources/screenshots" + nombreArchivo + "_" + System.currentTimeMillis() + ".png";
            File destino = new File(rutaDestino);
            Files.createDirectories(destino.getParentFile().toPath());
            Files.copy(screenshot.toPath(), destino.toPath());
            System.out.println("📸 Screenshot guardado en: " + destino.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TomarScreenshot con(WebDriver driver, String nombreArchivo) {
        return new TomarScreenshot(driver, nombreArchivo);
    }
}
