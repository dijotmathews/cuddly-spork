package lc150;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstr {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int l = 0;
        if(s.isEmpty())
            return result;


        Set<Character> found = new HashSet<>();
        found.add(s.charAt(l));
        result = 1;
        for(int r = 1; r < s.length() ; r++) {
            while (found.contains(s.charAt(r))) {
                found.remove(s.charAt(l));
                l = l + 1;

            }
            found.add(s.charAt(r));
            result = Integer.max(result, r - l +1);


        }
        return  result;
    }


    public static void main(String[] args) {
        String s = "asdfgh";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
