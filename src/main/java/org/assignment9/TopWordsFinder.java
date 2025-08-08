package org.assignment9;
import java.util.*;

public class TopWordsFinder {
    public static void main(String[] args) {
        String paragraph = "Rahul and Priya went to the market. Priya bought apples. Rahul bought mangoes. Priya loves fruits.";
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 3 frequent words:");
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " => " + list.get(i).getValue());
        }
    }
}

