import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}
