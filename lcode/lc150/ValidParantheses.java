package lc150;

import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses  {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> counter = new HashMap<>();

        counter.put(')', '(');
        counter.put('}', '{');
        counter.put(']', '[');
       boolean res = false;
        if(s.length() % 2 != 0)
            return res;

        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(counter.containsKey(ch) && !st.empty() && st.peek() == counter.get(ch)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        if(st.empty()) {
            return true;
        }

        return false;

    }
    public static void main(String[] args) {
       String s = "}(";
       System.out.println(isValid(s));
    }
}
