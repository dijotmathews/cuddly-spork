package lc150;

import java.util.HashMap;

public class RansomeNote {


    public static boolean canConstruct(String ransomeNote, String magazine) {

        HashMap<Character, Integer> alphabets = new HashMap<>();


        for(int i=0; i<magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if(alphabets.containsKey(c)) {
                Integer count = alphabets.get(c);
                alphabets.put(c, ++count);
            } else {
                alphabets.put(c, 1);
            }

        }

        for(int i = 0; i < ransomeNote.length(); i++){
            Character rc = ransomeNote.charAt(i);

            if(!alphabets.containsKey(rc) ) {
                return false;
            }
            if(alphabets.get(rc) == 0) {
                return false;
            }


            int count = alphabets.get(rc);
            alphabets.put(rc, --count);


        }


        return true;
    }

    public static void main(String[] args) {
        String ransomeNote = "aa";

        String magazine = "tta";

        if(canConstruct(ransomeNote, magazine)) {
            System.out.println("Found");
        }
    }

}
