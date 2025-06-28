package threadcise;


import static java.lang.Thread.sleep;

public class ThreadLambda {

    public static void main(String[] args) {
        Thread hi =  new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hi!!");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Hi Thread");


        Thread hello = new Thread(() -> {

            for(int i = 0; i < 10; i++) {
                System.out.println("Hello!!");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Hello Thread");

        System.out.println(hi.getName());
        System.out.println(hello.getName());

        hi.start();
        hello.start();


        System.out.println("In main thread. Bye!!");
    }
}
