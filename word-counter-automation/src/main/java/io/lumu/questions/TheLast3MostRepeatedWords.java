package io.lumu.questions;

import io.lumu.user_interfaces.KeywordDensity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

public class TheLast3MostRepeatedWords implements Question<String[][]> {
    @Override
    public String[][] answeredBy(Actor actor) {
        String[][] mostRepeatedWords = new String[3][2];
        actor.attemptsTo(Scroll.to(KeywordDensity.MOST_REPEATED_WORD));
        List<WebElementFacade> listsMostRepeatedWords = KeywordDensity.MOST_REPEATED_WORD.resolveAllFor(actor);
        List<WebElementFacade> listsCount = KeywordDensity.MOST_REPEATED_WORD_COUNT.resolveAllFor(actor);
        for (int i = 0; i < 3; i++) {
            mostRepeatedWords[i][0] = listsMostRepeatedWords.get(i).getText();
            mostRepeatedWords[i][1] = listsCount.get(i).getText().split("\\(")[0].trim();
        }
        return mostRepeatedWords;
    }

    public static TheLast3MostRepeatedWords inKeywordDensity() {
        return new TheLast3MostRepeatedWords();
    }
}
