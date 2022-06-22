package io.lumu.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/word_counter.feature",
        glue = "io.lumu.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class WordCounter {
}
