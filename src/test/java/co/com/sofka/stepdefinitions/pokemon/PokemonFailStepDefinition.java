package co.com.sofka.stepdefinitions.pokemon;

import co.com.sofka.models.pokeapi.Abilities;
import co.com.sofka.question.GetUserQuestion;
import co.com.sofka.question.ResponseCode;
import co.com.sofka.task.GetUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class PokemonFailStepDefinition {
    private static final String restApiUrl = "https://pokeapi.co/noexiste";
    Actor actor;

    @Given("el usuario necesita verificar el pokemon ditto")
    public void elUsuarioNecesitaVerificarElPokemonDitto() {
        actor = Actor.named("Valeria")
                .whoCan(net.serenitybdd.screenplay.rest.abilities.CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                GetUsers.fromPage("/api/v2/pokemon/ditto")
        );
    }
    @Then("el usuario no podra verificar porque saldra un mensaje de Not Found")
    public void elUsuarioNoPodraVerificarPorqueSaldraUnMensajeDeNotFound() {
        actor.should(
                seeThat("El código de respuesta", ResponseCode.was(), equalTo(SC_NOT_FOUND))
        );
    }
}
