package lc150;

public class LastWord {
    public static int lengthOfLastWord(String s) {
        boolean start = false;
        int count = 0;
        for(int i = s.length() -1; i >=0; i--) {
            char charAtI = s.charAt(i);

            if(charAtI != ' '){
                if(!start)
                    start = true;
                count++;
                System.out.println(charAtI);
            } else if (charAtI == ' ' && start){
                break;
            }

        }
        return count;
    }
    public static void main(String[] args) {
//        String s = "Hello World";
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s));
    }
}
