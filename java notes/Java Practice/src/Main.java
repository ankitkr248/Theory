import Threads.MyThread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int count = 0;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<10000;i++)
                count++;
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0;i<10000;i++)
                count++;
        });
        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("count" + count);
//            thread.interrupt();
        } catch (Exception e) {
            System.out.println("error in exceptioon" + e);
            throw new RuntimeException(e);
        }
    }
}