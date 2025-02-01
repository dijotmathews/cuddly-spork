public class Subsequence {
    public static boolean isSubsequence(String s, String t) {
        int  sPtr =0;
        int tPtr = 0;
        int sSize = s.length();
        int tSize = t.length();

        while(sPtr < sSize && tPtr < tSize) {

            if(s.charAt(sPtr) == t.charAt(tPtr)) {
                sPtr++;
            }
            tPtr++;

        }
        return sPtr == sSize ;
    }
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));

    }
}
