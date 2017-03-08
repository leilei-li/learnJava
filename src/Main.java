public class Main {
    public static void main(String[] args) {
        Myrunnable runnable = new Myrunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.setName("t1");
        t1.start();
        t2.setName("t2");
        t2.start();

    }
}
