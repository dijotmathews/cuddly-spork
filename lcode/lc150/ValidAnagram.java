package lc150;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int sLen  = s.length();
        int tLen = t.length();

        if (sLen != tLen)
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < sLen; i++) {
            if(!sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), 1) ;
            } else {
                int count =  sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), ++count);
            }

            if(!tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), 1);
            } else {
                int count = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), ++count);
            }



        }


        for(Character c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) {
               return false;
            }
        }
        return true;

    }
}
