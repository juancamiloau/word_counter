package io.lumu.utils;

import java.util.ArrayList;
import java.util.List;

public class Count {
    private String paragraphs;

    private Count(String paragraphs) {
        this.paragraphs = paragraphs;
    }

    public static Count theString(String string) {
        return new Count(string);
    }

    public int words() {
        if (paragraphs.length() > 0)
            return paragraphs.replace("\n", " ").split(" ").length;
        else
            return 0;
    }

    public int characters() {
        return paragraphs.replace("\n", "").length();
    }


    public String[][] getLast3MostRepeatedWords() {
        String[] words = paragraphs.replace("\n", " ").replace("."," ").split(" ");
        List<String> wordsNoRepeated = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (!wordsNoRepeated.contains(words[i])) {
                wordsNoRepeated.add(words[i]);
            }
        }
        String[][] mostRepeatedWords = new String[3][2];
        for (int k = 0; k < mostRepeatedWords.length; k++) {
            String mostRepeated = words[0];
            int countMostRepeated = 0;
            for (String word : wordsNoRepeated) {
                int count = 0;
                for (int i = 0; i < words.length; i++) {
                    if (word.equalsIgnoreCase(words[i]))
                        count++;
                }
                if (count > countMostRepeated) {
                    mostRepeated = word;
                    countMostRepeated = count;
                }
            }
            mostRepeatedWords[k][0] = mostRepeated;
            mostRepeatedWords[k][1] = "" + countMostRepeated;
            wordsNoRepeated.remove(mostRepeated);
        }
        return mostRepeatedWords;
    }

}
