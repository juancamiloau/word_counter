package io.lumu.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.lumu.questions.TheLast3MostRepeatedWords;
import io.lumu.user_interfaces.Details;
import io.lumu.utils.Count;
import io.lumu.utils.Generate;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.TextArea;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static io.lumu.user_interfaces.Details.COUNT_RESULT_TEXT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WordCounterStepDefinitions {

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
    }

    @Given("{string} is on wordcounter")
    public void actorIsOnWordcounter(String nameActor) {
        OnStage.theActorCalled(nameActor).can(BrowseTheWeb.with(hisBrowser));
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://wordcounter.net/"));
    }

    @When("he enters a random paragraphs")
    public void heEntersARandomParagraphs() {
        String randomParagraphs = Generate.aRandomParagraphs();
        OnStage.theActorInTheSpotlight().attemptsTo(Enter.theValue(randomParagraphs).into(TextArea.withNameOrId("box")));
        OnStage.theActorInTheSpotlight().remember("randomParagraphs", randomParagraphs);
    }

    @When("he enters a random paragraphs and clean field")
    public void heEntersARandomParagraphsAndCleanField() {
        String randomParagraphs = Generate.aRandomParagraphs();
        OnStage.theActorInTheSpotlight().attemptsTo(Enter.theValue(randomParagraphs).into(TextArea.withNameOrId("box")),
                Clear.field(TextArea.withNameOrId("box")));
        OnStage.theActorInTheSpotlight().remember("randomParagraphs", "");
    }

    @When("he enters repeated random words")
    public void heEntersRepeatedRandomWords() {
        String randomParagraphs = Generate.aRandomParagraphsWithRepeatedWords();
        OnStage.theActorInTheSpotlight().attemptsTo(Enter.theValue(randomParagraphs).into(TextArea.withNameOrId("box")));
        OnStage.theActorInTheSpotlight().remember("randomParagraphs", randomParagraphs);
    }

    @Then("he should see the number of words")
    public void heShouldSeeTheNumberOfWords() {
        String randomParagraphs = OnStage.theActorInTheSpotlight().recall("randomParagraphs");
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(Details.WORDS).asInteger(),
                is(equalTo(Count.theString(randomParagraphs).words()))));

    }

    @Then("he should see the number of characters")
    public void heShouldSeeTheNumberOfCharacters() {
        String randomParagraphs = OnStage.theActorInTheSpotlight().recall("randomParagraphs");
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(Details.CHARACTERS).asInteger(),
                is(equalTo(Count.theString(randomParagraphs).characters()))).because("Count chars is not correct"));
    }

    @Then("he should see the text with number of words and characters")
    public void heShouldSeeTheTextWithNumberOfWordsAndCharacters() {
        String randomParagraphs = OnStage.theActorInTheSpotlight().recall("randomParagraphs");
        int words = Count.theString(randomParagraphs).words();
        int characters = Count.theString(randomParagraphs).characters();
        String textCountBoth = String.format("%d words %d characters",words,characters);
        OnStage.theActorInTheSpotlight().should(seeThat(Text.of(COUNT_RESULT_TEXT), is(equalTo(textCountBoth))));
    }

    @Then("he should see the most repeated words")
    public void heShouldSeeTheMostRepeatedWords() {
        String randomParagraphs = OnStage.theActorInTheSpotlight().recall("randomParagraphs");
        String[][] mostRepeatedWords = Count.theString(randomParagraphs).getLast3MostRepeatedWords();
        OnStage.theActorInTheSpotlight().should(seeThat(TheLast3MostRepeatedWords.inKeywordDensity(),
                is(equalTo(mostRepeatedWords))));
    }

}
