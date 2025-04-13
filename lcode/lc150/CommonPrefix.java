package lc150;

import java.util.Arrays;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        if(strs.length == 1) {
            return strs[0];
        }

        String firstString = strs[0];
        String lastString = strs[strs.length-1];
        if(firstString.length() == 0 || lastString.length() == 0) {
            return "";
        }

        int idx = 0;

        while(idx < firstString.length() && idx < lastString.length()) {
            if(firstString.charAt(idx) != lastString.charAt(idx)) {
                break;
            }
            idx++;
        }


        return firstString.substring(0,idx);


    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car", ""};
//        String[] strs = {"a",""};
//        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));

    }
}
