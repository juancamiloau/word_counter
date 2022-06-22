package io.lumu.word_frecuency_counter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CounterMain {
    public static void main(String[] args) {
        File file = new File("src/main/resources/fileToRead.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String line;
            String allLines = "";
            while ((line = bufferedReader.readLine()) != null) {
                allLines += line+ "\n";
            }
            System.out.println(allLines);
            System.out.println(words(allLines) + " words");
            System.out.println(characters(allLines) + " characters");

            String[][] histogram = getMostRepeatedWords(allLines);
            for (int i = 0; i < histogram.length; i++) {
                System.out.println(histogram[i][0] + ": " + histogram[i][1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int words(String allLines) {
        if (allLines.length() > 0)
            return allLines.replace("\n", " ").split(" ").length;
        else
            return 0;
    }

    public static int characters(String allLines) {
        return allLines.replace("\n", "").length();
    }


    public static String[][] getMostRepeatedWords(String allLines) {
        String[] words = allLines.replace("\n", " ").replace(".", " ").split(" ");
        List<String> wordsNoRepeated = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (!wordsNoRepeated.contains(words[i])) {
                wordsNoRepeated.add(words[i]);
            }
        }
        String[][] mostRepeatedWords = new String[wordsNoRepeated.size()][2];
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
