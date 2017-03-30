import java.util.ArrayList;

/**
 * Created by lileilei on 2017/3/17.
 */
public class Sort {
    private void printNum(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public void quickSort(int[] num) {
        quickSort1(num, 0, num.length - 1);
        printNum(num);
    }

    private void quickSort1(int[] num, int low, int high) {
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
        if (l > low) quickSort1(num, low, l - 1);
        if (h < high) quickSort1(num, l + 1, high);
    }//quick sort

    public void bubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < num.length; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        printNum(num);
    }

    public void insertSort(int[] num) {
        for (int i = 1; i < num.length; i++)
            for (int j = i; j > 0; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                }
            }
        printNum(num);
    }

    public void selectSort(int[] num) {
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
        printNum(numSorted);
    }

    public void heapSort(int[] num) {
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
        printNum(num);
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

    public void shellSort(int[] num) {
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
        printNum(num);
    }

    public void mergeSort(int[] num) {
        mergesort1(num, 0, num.length - 1);
        printNum(num);

    }

    private void mergesort1(int[] num, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergesort1(num, low, mid);
            mergesort1(num, mid + 1, high);
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

    public void countSort(int[] num) {
        int max, min;
        max = min = num[0];
        int[] numSorted = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
            if (min > num[i]) {
                min = num[i];
            }
        }//找出数组中最大最小值，便于建立辅助数组
        int d = max - min + 1;
        int[] c = new int[d];//辅助数组
        for (int i = 0; i < num.length; ++i) {
            c[num[i] - min] = c[num[i] - min] + 1;
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = num.length - 1; i >= 0; --i) {
            c[num[i] - min] = c[num[i] - min] - 1;
            numSorted[c[num[i] - min]] = num[i];//按存取的方式取出c的元素
        }
        printNum(numSorted);
    }

    public void bucketSort(int[] num) {//映射函数为f(x)=k/10
        int buckets = 10;//建造十个桶
        ArrayList<ArrayList<Integer>> bucketNum = new ArrayList<ArrayList<Integer>>();//建立一个桶的索引
        for (int i = 0; i < buckets; i++) {
            bucketNum.add(new ArrayList<Integer>());
        }//初始化十个桶的索引
        for (int i = 0; i < num.length; i++) {
            int pos = num[i] / 10;//通过映射函数选择放在哪个桶
            bucketNum.get(pos).add(num[i]);
        }
        for (int i = 0; i < buckets; i++) {
            if (bucketNum.get(i).isEmpty()) {
                continue;
            } else {
                bucketNum.get(i).sort(Integer::compareTo);//这里使用了Arraylist自带的sort方式，可以自己写排序算法
            }

        }
        for (int i = 0; i < buckets; i++) {
            if (bucketNum.get(i).isEmpty()) {
                continue;
            } else {
                for (int j = 0; j < bucketNum.get(i).size(); j++) {
                    System.out.print(bucketNum.get(i).get(j) + " ");
                }
            }
        }
        System.out.println();
    }


}
