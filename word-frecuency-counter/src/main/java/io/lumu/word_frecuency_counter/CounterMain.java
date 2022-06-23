package io.lumu.word_frecuency_counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CounterMain {
    public static void main(String[] args) {
        File file = new File("src/main/resources/fileToRead.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String line;
            String allLines = "";
            while ((line = bufferedReader.readLine()) != null) {
                allLines += line+ "\n";
            }
            String[] words = allLines.split("[\\s|\\n|.]");
            System.out.println(allLines);
            System.out.println(words.length + " words");
            System.out.println(allLines.replace("\n","").length() + " characters");
            getMostRepeatedWords(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getMostRepeatedWords(String[] words) {
        HashMap<String, Integer> dictionary = new HashMap();
        for (String word: words) {
            word = word.toLowerCase();
            Integer value = dictionary.get(word);
            dictionary.put(word, value ==null ? 1 : value+1);
        }
        dictionary.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }
}
