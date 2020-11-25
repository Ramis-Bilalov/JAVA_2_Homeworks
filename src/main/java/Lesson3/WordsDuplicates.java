package Lesson3;

import java.util.*;


public class WordsDuplicates {

    public static Collection<String> getUniqueWords(String path){
        Scanner in = new Scanner(
                WordsDuplicates.class.getResourceAsStream(path));
        Set<String> set = new HashSet<>();
        while(in.hasNextLine()) {
            String[] data = in.nextLine().split(",");
            Collections.addAll(set, data);
        } return set;
    }

    public static Map<String, Integer> getUniqueWordsCount(String path) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner in = new Scanner(
                WordsDuplicates.class.getResourceAsStream(path));
        while(in.hasNextLine()) {
            String[] data = in.nextLine().split(",");
            for(String key : data) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;

    }

    public static void main(String[] args) {
        System.out.println(getUniqueWords("words.csv"));
        System.out.println(getUniqueWordsCount("words.csv"));
    }
}
