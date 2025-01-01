import java.util.HashMap;

public class IntToRoman {
    public static String intToRoman(int num) {
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n =    {1000, 900, 500, 400,  100,  90,  50,   40, 10, 9, 5, 4, 1 };

        String result = "";

        for(int i = 0; i < n.length; i++) {
            int part = num / n[i];
            if(part != 0) {
                break;
            }
            System.out.println(part);

            num = num % n[i];
        }
        return  result;
    }

    public static void main(String[] arg) {
        int num = 3749;
        System.out.println(intToRoman(num));
    }
}
