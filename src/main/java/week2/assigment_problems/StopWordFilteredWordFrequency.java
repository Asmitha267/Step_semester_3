package main.java.week2.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase and remove punctuation
        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        // Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            // Check whether the word is a stop word
            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Count only non-stop words
            if (!isStopWord) {

                frequency.put(
                        words[i],
                        frequency.getOrDefault(words[i], 0) + 1
                );
            }
        }

        // Sort by frequency in descending order
        frequency.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue()
                                .reversed()
                )
                .forEach(entry ->
                        System.out.println(
                                entry.getKey()
                                        + ": "
                                        + entry.getValue()
                        )
                );
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
