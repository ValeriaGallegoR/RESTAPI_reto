package co.com.sofka.question;

import co.com.sofka.models.pokeapi.Example;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUserQuestion implements Question {
 @Override
public Example answeredBy(Actor actor){
     return SerenityRest.lastResponse().as(Example.class);
 }
}
