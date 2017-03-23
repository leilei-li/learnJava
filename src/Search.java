import java.util.ArrayList;

/**
 * Created by lileilei on 2017/3/23.
 */
public class Search {
    public void OrderSearch(int[] num, int target) {
        int pos = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                pos = i;
                break;
            }
        }
        System.out.println(pos);
    }

    private int[] initBinarySearch(int[] num) {//采用冒泡排序把无序表变成有序的
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < num.length; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        return num;
    }

    public void BinarySearch(int[] n, int target) {
        int[] num = initBinarySearch(n);
        int low = 0;
        int high = num.length - 1;
        int mid = (low + high) / 2;
        int pos = -1;
        while ((low <= high) && (low <= num.length - 1) && (high <= num.length - 1)) {
            if (num[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            if (num[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            if (num[mid] == target) {
                pos = mid;
                break;
            }
        }
        System.out.println(pos);
    }
}
