package lc150;

import java.util.HashMap;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> forward = new HashMap<>();
        HashMap<Character, Character> backward = new HashMap<>();


        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i) ;
            char tChar = t.charAt(i);

            if ((forward.containsKey(sChar) && forward.get(sChar) != tChar) ||( backward.containsKey(tChar) && backward.get(tChar) != sChar))
                return false;
            forward.put(sChar, tChar);
            backward.put(tChar, sChar);

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        if(!isIsomorphic(s, t)) {
            System.out.println("Not isomorphic");
        }

    }

}