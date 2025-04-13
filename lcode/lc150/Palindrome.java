package lc150;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() -1;

        while(l < r) {

            char left = s.charAt(l);
            char right = s.charAt(r);

            if(l < r && !isAlphanumeric(left)) {
                l++;
            } else if (r > l && !isAlphanumeric(right)) {
                r--;
            } else {
                left = s.charAt(l);
                right = s.charAt(r);

                if(Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                l++;
                r--;
            }


        }
        return true;


    }

    public static boolean isAlphanumeric(char c) {
        int zero = (int) '0';
        int nine = (int) '9';
        int ch = (int) c;

        boolean isNumber =  zero <= ch && ch <= nine ? true : false;

        int Ay = (int) 'A';
        int Zy = (int) 'Z';


        boolean isUpperAlphabet = Ay <= ch && ch <= Zy ? true : false;

        int ay = (int) 'a';
        int zy = (int) 'z';

        boolean isLowerAlphabet = ay <= ch && ch <= zy ? true : false;

        return isNumber || isUpperAlphabet || isLowerAlphabet;

    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "malayalam";
        String s = "race a car";
//        String s = "raceacar";
//        String s = " ";
//        String s = "A.";
        System.out.println(isPalindrome(s));

    }
}
