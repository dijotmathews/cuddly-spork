package misc;

public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char currentChar = s.charAt(i);

            switch(currentChar) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    if(i > 0 && s.charAt(i-1) == 'I'){
                        result -= 1;
                        i--;
                    }

                    break;
                case 'X':
                    result += 10;
                    if(i > 0 && s.charAt(i-1) == 'I'){
                        result -= 1;
                        i--;
                    }
                    break;
                case 'L':
                    result += 50;
                    if(i > 0 && s.charAt(i-1) == 'X'){
                        result -= 10;
                        i--;
                    }
                    break;
                case 'C':
                    result += 100;
                    if(i > 0 && s.charAt(i-1) == 'X'){
                        result -= 10;
                        i--;
                    }
                    break;
                case 'D':
                    result += 500;
                    if(i > 0 && s.charAt(i-1) == 'C'){
                        result -= 100;
                        i--;
                    }
                    break;
                case 'M':
                    result += 1000;
                    if(i > 0 && s.charAt(i-1) == 'C'){
                        result -= 100;
                        i--;
                    }
                    break;
            }

        }
        return result;
    }
    public static void main(String[] args){
//        String s = "IX";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";

        System.out.println(romanToInt(s));
    }
}
