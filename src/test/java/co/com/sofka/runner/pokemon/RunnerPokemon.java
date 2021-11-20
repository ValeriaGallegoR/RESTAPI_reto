package co.com.sofka.runner.pokemon;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features.pokemon"},
        glue = {"co.com.sofka.stepdefinitions.pokemon"},
        tags = "not @ignore"
)

public class RunnerPokemon {
}
