package io.lumu.utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    private Generate() {
    }

    private static final Faker FAKER = new Faker();

    public static String aRandomParagraphs() {
        List<String> paragraphs = FAKER.lorem().paragraphs(FAKER.number().numberBetween(3, 5));
        String random = "";
        for (String paragraph : paragraphs) {
            random += paragraph + "\n";
        }
        return random;
    }

    public static String aRandomParagraphsWithRepeatedWords() {
        List<String> paragraphs = FAKER.lorem().paragraphs(FAKER.number().numberBetween(1, 1));
        String random = "";
        for (String paragraph : paragraphs) {
            random += paragraph + "\n";

        }
        String word = FAKER.lorem().word();
        for (int i = 0; i < FAKER.number().numberBetween(5, 10); i++) {
            random += word + " ";
        }
        word = FAKER.lorem().word();
        for (int i = 0; i < FAKER.number().numberBetween(10, 15); i++) {
            random += word + " ";
        }
        word = FAKER.lorem().word();
        for (int i = 0; i < FAKER.number().numberBetween(15, 20); i++) {
            random += word + " ";
        }
        return random;
    }


}
