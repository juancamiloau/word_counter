package io.lumu.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class KeywordDensity {
    private KeywordDensity(){}
    public static final Target MOST_REPEATED_WORD = Target.the("Most repeated keyword")
            .locatedBy("//div[@id='kwd-accordion-data']//span[@class='word']");
    public static final Target MOST_REPEATED_WORD_COUNT = Target.the("Most repeated keyword")
            .locatedBy("//div[@id='kwd-accordion-data']//span[@class='badge']");
}
