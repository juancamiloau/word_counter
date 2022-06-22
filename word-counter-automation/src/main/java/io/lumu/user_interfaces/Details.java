package io.lumu.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Details {
    private Details(){}
    public static final Target WORDS = Target.the("Words count").located(By.id("word_count"));
    public static final Target CHARACTERS = Target.the("Character count").located(By.id("character_count"));
    public static final Target COUNT_RESULT_TEXT = Target.the("Count result text")
            .locatedBy("//*[@class='counted']");
}
