package threadcise;

import static java.lang.Thread.sleep;

class Hi extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hi!!");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Hello implements Runnable {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello!!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadExample {

    public static void main(String[] args) {
        Thread hi =  new Hi();
        Hello hell = new Hello();
        Thread hello = new Thread(hell);
        hi.start();
        hello.start();
    }
}
