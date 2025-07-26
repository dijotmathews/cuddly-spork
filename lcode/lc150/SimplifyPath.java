package lc150;


import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        String newPath = path + "/";
        Stack<String> dirs = new Stack();
        StringBuilder cur = new StringBuilder();

         for(int i =0; i < newPath.length(); i ++) {
            if(newPath.charAt(i) == '/') {
                if(!cur.toString().isEmpty()) {
                    if(cur.toString().equals("..")) {
                        if(!dirs.isEmpty())
                            dirs.pop();
                    } else if (!cur.toString().equals(".") && !cur.toString().isBlank()) {
                        dirs.add(cur.toString());
                    }
                    cur.setLength(0);
                }
            } else {
                cur = cur.append(newPath.charAt(i)) ;
            }

         }
        return "/"+ dirs.stream().collect(Collectors.joining("/"));
    }

    public static void main(String[] args) {
//        String path = "/home/user/Documents/../Pictures";
        String path = "/.../a/../b/c/../d/.";

        String res = simplifyPath(path);

        System.out.println(res);
    }

}
