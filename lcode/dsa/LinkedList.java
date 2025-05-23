package dsa;

public class LinkedList  {

    Node head = null;


    public void add(int data) {
        Node newNode = new Node(data);

        Node current = head;

        if(head == null) {
            head = newNode;

        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
    }


    public void printValues() {
        Node current = head;

        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(current.data);

    }
    

    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        newNode.next = head;
        head = newNode;
    }


    public void delete(int data) {
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if(current.next != null)
            current.next = current.next.next;   


    }
}


class Node {
    Node next = null;
    int data;

    Node(int data){
        this.data = data;
        this.next = null;
    }
    

}
