//https://www.youtube.com/watch?v=ohBNdSJyLh8
public class IntToRoman {
    public static String intToRoman(int num) {
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n =    {1000, 900, 500, 400,  100,  90,  50,   40, 10, 9, 5, 4, 1 };

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n.length; i++) {
            int part = num / n[i];
            if(part != 0) {
                result.append(catStr(r[i], part));
                num = num % n[i];
            }


        }
        return  result.toString();
    }

    public static String catStr(String str, int n) {
        if (str == null || n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] arg) {
        int num = 3749;
        System.out.println(intToRoman(num));
    }
}
