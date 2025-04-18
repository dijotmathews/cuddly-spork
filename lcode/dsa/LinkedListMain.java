package dsa;

public class LinkedListMain {
    
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();

        nums.add(4);
        nums.add(3);
        nums.add(8);

        nums.addFirst(1);

        nums.delete(3);

        nums.printValues();
    }
}


