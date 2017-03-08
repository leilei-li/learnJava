/**
 * Created by lileilei on 2017/3/8.
 */
public class Myrunnable implements Runnable {
    private int a = 10;

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        if(tName.equals("t1")){
            t1go();
        }
        if(tName.equals("t2")){
            t2go();
        }
    }

    private void t1go() {
        String tName = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(tName + " " + a);
            a = a - 1;
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
        }

    }
    private void t2go() {
        String tName = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println("this is "+tName);
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
        }

    }
}
