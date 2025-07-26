package lc150;

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        int lenPattern = pattern.length();
        String[] words = s.split(" ");
        int lenWords = words.length;

        if(lenWords != lenPattern)
            return false;


        for(int i = 0; i < lenPattern; i++) {
            if((charToWord.containsKey(pattern.charAt(i)) && !charToWord.get(pattern.charAt(i)).equals(words[i]))  ||  ( wordToChar.containsKey(words[i]) && !wordToChar.get(words[i]).equals(pattern.charAt(i))))
                return false;

            charToWord.put(pattern.charAt(i), words[i]);
            wordToChar.put(words[i], pattern.charAt(i));
        }
        return true;
    }


    public static void main(String[] args) {
        String patten = "abbb";
        String s = "dog cat cat dog";
        if(wordPattern(patten, s)) {
            System.out.println("Found");
        }

    }
}
