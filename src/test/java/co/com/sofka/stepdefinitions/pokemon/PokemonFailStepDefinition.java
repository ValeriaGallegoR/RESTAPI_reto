package co.com.sofka.stepdefinitions.pokemon;

import co.com.sofka.models.pokeapi.Abilities;
import co.com.sofka.question.GetUserQuestion;
import co.com.sofka.question.ResponseCode;
import co.com.sofka.task.GetUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class PokemonFailStepDefinition {
    private static final String restApiUrl = "https://pokeapi.co/val";
    Actor actor;

    @Given("el usuario necesita verificar el pokemon ditto")
    public void elUsuarioNecesitaVerificarElPokemonDitto() {
        actor = Actor.named("Valeria")
                .whoCan(net.serenitybdd.screenplay.rest.abilities.CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                GetUsers.fromPage("/api/v2/pokemon/ditto")
        );
    }

    @When("el sistema verifica que la habilidad del pokemon exista")
    public void elSistemaVerificaQueLaHabilidadDelPokemonExista() {
        actor.should(
                seeThat("El código de respuesta", ResponseCode.was(), equalTo(404))
        );
    }

    @Then("el usuario no podra ver la habilidad de ditto porque esta no existe")
    public void elUsuarioNoPodraVerLaHabilidadDeDittoPorqueEstaNoExiste() {
            Abilities result = new GetUserQuestion().answeredBy(actor).getAbilities().stream()
                    .filter(x -> x.getAbility().getName().equals("SuperFuerza")).findFirst().orElse(null);
            actor.should(
                    seeThat("El nombre de la habilidad es: ", act -> result, notNullValue())
            );
        }
}
