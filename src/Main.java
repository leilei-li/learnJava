public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int[] price = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] r = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] X = new String[]{"A", "B", "C", "B", "D", "A", "B"};
        String[] Y = new String[]{"B", "D", "C", "A", "B", "A"};
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

//        Search search = new Search();
//        search.orderSearch(num, 3);
//        search.binarySearch(num, 3);
//        search.binaryTreeSearch(num, 3);

        Algorithm algorithm = new Algorithm();
//        int[] result = algorithm.getMaxSubArray(num, 0, 9);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//        for (int i = 1; i < 11; i++) {
//            System.out.println(algorithm.memoizedCutRodAux(price, r, i));
//            System.out.println(algorithm.bottomUpCutRod(price, r, i));
//        }
        algorithm.getLCS(X, Y);
    }
}
