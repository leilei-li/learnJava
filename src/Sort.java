import com.sun.scenario.effect.Merge;

/**
 * Created by lileilei on 2017/3/17.
 */
public class Sort {

    public void QuickSort(int[] num) {
        QuickSort1(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }

    private void QuickSort1(int[] num, int low, int high) {
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
        if (l > low) QuickSort1(num, low, l - 1);
        if (h < high) QuickSort1(num, l + 1, high);
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

    public void InsertSort(int[] num) {
        for (int i = 1; i < num.length; i++)
            for (int j = i; j > 0; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                }
            }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");

        }
    }

    public void SelectSort(int[] num) {
        int[] numSorted = new int[num.length];
        int pos = 0;
        int p = 0;
        int n = num[0];
        while (pos < 10) {
            for (int i = 0; i < num.length - 1; i++) {
                if (n > num[i]) {
                    n = num[i];
                    p = i;
                }
            }
            numSorted[pos] = n;
            num[p] = 99999;
            p = 0;
            n = num[pos];
            pos++;
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(numSorted[i] + " ");
        }
    }

    public void HeapSort(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        buildMaxHeap(num);
        for (int i = num.length - 1; i >= 1; i--) {
            int temp = num[0];
            num[0] = num[i];
            num[i] = temp;
            maxHeap(num, i, 0);
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }

    private void buildMaxHeap(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }

        int half = num.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(num, num.length, i);
        }
    }

    private void maxHeap(int[] num, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && num[left] > num[index]) {
            largest = left;
        }

        if (right < heapSize && num[right] > num[largest]) {
            largest = right;
        }

        if (index != largest) {

            int temp = num[index];
            num[index] = num[largest];
            num[largest] = temp;
            maxHeap(num, heapSize, largest);
        }
    }

    public void ShellSort(int[] num) {
        int d = num.length;
        while (d != 1) {
            d = d / 2;
            for (int i = 0; i < num.length; i++)
                for (int j = i; j + d < num.length; j = j + d) {//分组后从i开始，每d增量拿出来一次
                    if (num[j] > num[j + d]) {
                        int temp = num[j + d];
                        num[j + d] = num[j];
                        num[j] = temp;
                    }
                }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }

    public void MergeSort(int[] num) {
        MergeSort1(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }

    }

    private void MergeSort1(int[] num, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            MergeSort1(num, low, mid);
            MergeSort1(num, mid + 1, high);
            merge(num, low, mid, high);
        }

    }

    private void merge(int[] num, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (num[i] < num[j]) {
                temp[k++] = num[i++];
            } else {
                temp[k++] = num[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = num[i++];
        }
        while (j <= high) {
            temp[k++] = num[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            num[k2 + low] = temp[k2];
        }
    }
}
