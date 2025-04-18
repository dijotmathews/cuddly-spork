package dsa;

public class Stack {

    private int[] data = new int[3];
    int top ;
    int size;

    public  Stack() {
        top = -1;
        size = data.length;
    }

    public void push(int data) {
        if(top < size - 1)  {
            this.data[++top] = data;

        } else {
            System.out.println("Stack full");
        }
    }

    public void printStack() {
        for(int i = 0; i <= top; i++) {
            System.out.print(data[i] + " ");
        }
         System.out.println();
    }

    public int pop() {
        return data[top--];

    }

    public int peek() {
        return data[top];
    }
}
