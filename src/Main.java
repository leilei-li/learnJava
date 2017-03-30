public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
//        Sort sort = new Sort();
//        sort.quickSort(num);
//        sort.bubbleSort(num);
//        sort.insertSort(num);
//        sort.selectSort(num);
//        sort.heapSort(num);
//        sort.shellSort(num);
//        sort.mergeSort(num);
//        sort.countSort(num);
//        sort.bucketSort(num);

        Search search = new Search();
//        search.orderSearch(num, 3);
//        search.binarySearch(num, 3);
        search.binaryTreeSearch(num, 3);
        

    }
}
