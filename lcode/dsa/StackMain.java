package dsa;


public class StackMain {

    public static void main(String[] args) {
        Stack s = new Stack();


        s.push(10);
        s.push(10);
        s.push(10);
        s.push(10);
        s.pop();

        s.peek();

        s.printStack();
    }

}
