package io.lumu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Count {
    private String paragraphs;

    private String[] words;
    private Count(String paragraphs) {
        this.paragraphs = paragraphs;
        words = paragraphs.split("[\\s|\\n|.]");
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
        HashMap<String, Integer> dictionary = new HashMap();
        for (String word: words) {
            word = word.toLowerCase();
            Integer value = dictionary.get(word);
            dictionary.put(word, value ==null ? 1 : value+1);
        }
        dictionary = SortMaps.sortByValue(dictionary);
        List<String> keys = new ArrayList(dictionary.keySet());
        List<Integer> values = new ArrayList(dictionary.values());
        String[][] wordsRepeated = new String[3][2];
        for (int i = 0; i < 3; i++) {
            wordsRepeated[i][0] = keys.get(i);
            wordsRepeated[i][1] = values.get(i).toString();
        }
        return wordsRepeated;
    }

}
