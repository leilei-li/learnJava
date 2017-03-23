public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3};
//        Sort sort = new Sort();
//        sort.QuickSort(num);
//        sort.BubbleSort(num);
//        sort.InsertSort(num);
//        sort.SelectSort(num);
//        sort.HeapSort(num);
//        sort.ShellSort(num);
//        sort.MergeSort(num);
//        sort.CountSort(num);
//        sort.BucketSort(num);

        Search search = new Search();
//        search.OrderSearch(num, 3);
//        search.BinarySearch(num, 3);
        search.BinaryTreeSearch(num,3);

    }
}
