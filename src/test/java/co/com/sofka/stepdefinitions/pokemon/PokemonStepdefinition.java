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

public class PokemonStepdefinition {

    private static final String restApiUrl = "https://pokeapi.co";
    Actor actor;

    @Given("el usuario necesita verificar las caracteristicas del pokemon ditto")
    public void elUsuarioNecesitaVerificarLasCaracteristicasDelPokemonDitto() {
        actor = Actor.named("Valeria")
                .whoCan(net.serenitybdd.screenplay.rest.abilities.CallAnApi.at(restApiUrl));
        actor.attemptsTo(
                GetUsers.fromPage("/api/v2/pokemon/ditto")
        );
    }

    @When("el sistema verifica que dicho pokemon exista")
    public void elSistemaVerificaQueDichoPokemonExista() {
        actor.should(
                seeThat("El código de respuesta", ResponseCode.was(), equalTo(200))
        );
    }

    @Then("el usuario pordra ver la habilidad del pokemon ditto")
    public void elUsuarioPordraVerLaHabilidadDelPokemonDitto() {
        Abilities result  = new GetUserQuestion().answeredBy(actor).getAbilities().stream()
                        .filter(x-> x.getAbility().getName().equals("limber")).findFirst().orElse(null);
        System.out.println(result);
        actor.should(
                seeThat("El nombre de la habilidad es: " , act -> result, notNullValue())
        );
        actor.should(
                seeThat("El nombre de la habilidad es: " , act -> result.getAbility().getName(),equalTo("limber"))
        );
    }
}
