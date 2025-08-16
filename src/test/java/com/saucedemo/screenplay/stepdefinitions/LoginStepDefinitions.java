package com.saucedemo.screenplay.stepdefinitions;

import com.saucedemo.screenplay.models.User;
import com.saucedemo.screenplay.questions.BuySuccessMessage;
import com.saucedemo.screenplay.questions.LoginSuccessMessage;
import com.saucedemo.screenplay.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static com.saucedemo.screenplay.utils.Urls.LOGIN_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
//Implementación en Java de los pasos definidos en Gherkin (Given, When, Then).
//Aquí se llama a tasks, interactions y questions.

@Epic("Login")
@Feature("Ingreso exitoso")
@DisplayName("Login exitoso con credenciales válidas")

public class LoginStepDefinitions {

    @Before
    public void prepareTestEnvironment() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario accede a la página de login")
    public void abrirPagina() {
        OnStage.theActorCalled("Tester")
                .wasAbleTo(OpenThePage.at(LOGIN_PAGE));
    }

    @When("ingresa credenciales válidas")
    public void loginValido() {
        User credentials = new User("standard_user", "secret_sauce");
        theActorInTheSpotlight().attemptsTo(Login.with(credentials));
    }

    @Then("debería ver el mensaje de login exitoso")
    public void validarLoginExitoso() {
        theActorInTheSpotlight().should(seeThat(LoginSuccessMessage.isVisible()));
    }

    @And("agrega dos productos al carrito")
    public void agrega_dos_productos_al_carrito() {
        theActorInTheSpotlight().attemptsTo(AgregarProductosCarrito.enLaPagina());
    }
    @And("visualiza el carrito")
    public void visualiza_el_carrito() {
        theActorInTheSpotlight().attemptsTo(VisualizarCarrito.enLaPagina());
    }
    @And("completa el formulario de compra")
    public void completa_el_formulario_de_compra() {
        theActorInTheSpotlight().attemptsTo(CompletarFormularioCompra.enLaPagina());
    }

    @And("debería ver el mensaje exitoso")
    public void debería_ver_el_mensaje_exitoso() {
        theActorInTheSpotlight().should(seeThat(BuySuccessMessage.isVisible()));
    }

}
