/**
 * Created by lileilei on 2017/3/8.
 */
public class Myrunnable implements Runnable {
    private int a = 0;

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        for (int i = 0; i < 1000; i++) {
            System.out.println(tName + " " + a);
            a = a - 1;
            try {
                //Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}
