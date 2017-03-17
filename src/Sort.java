/**
 * Created by lileilei on 2017/3/17.
 */
public class Sort {
    public void QuickSort(int[] num, int low, int high) {
        int l = low;
        int h = high;
        int povit = num[low];
        while (l < h) {
            while (l < h && num[h] >= povit)
                h--;
            if (l < h) {
                int temp = num[h];
                num[h] = num[l];
                num[l] = temp;
                l++;
            }
            while (l < h && num[l] <= povit)
                l++;

            if (l < h) {
                int temp = num[h];
                num[h] = num[l];
                num[l] = temp;
                h--;
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.print("\n");
        if (l > low) QuickSort(num, low, l - 1);
        if (h < high) QuickSort(num, l + 1, high);
    }//quick sort

    public void BubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < num.length; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
