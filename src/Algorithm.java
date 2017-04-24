import java.util.ArrayList;

/**
 * Created by lileilei on 2017/4/14.
 */
public class Algorithm {
    public int[] getMaxSubArray(int[] num, int low, int high) {
        if (low == high) return num;
        int mid = (low + high) / 2;
        int[] left = new int[3];
        int[] right = new int[3];
        int[] cross = new int[3];
        left = getMaxSubArray(num, low, mid);
        right = getMaxSubArray(num, mid + 1, high);
        cross = getMaxCrossMid(num, low, high, mid);
        if (left[2] >= right[2] && left[2] >= cross[2]) {
            return left;
        } else if (right[2] >= left[2] && right[2] >= cross[2]) {
            return right;
        } else {
            return cross;
        }
    }

    private int[] getMaxCrossMid(int[] num, int low, int high, int mid) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0; // 保存和的
        int left = 0; // 记录左边位置
        for (int i = mid; i >= low; i--) {
            sum = sum + num[i];
            if (sum > leftSum) { // 证明所加数字为正数，那么符合条件（因为最大子数组内正数越多指定越大）
                leftSum = sum;
                left = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int sum2 = 0;
        int right = 0; // 记录右边位置
        for (int i = mid + 1; i <= high; i++) {
            sum2 = sum2 + num[i];
            if (sum2 > rightSum) {
                rightSum = sum2;
                right = i;
            }
        }
        int[] result = new int[3];
        result[0] = left;
        result[1] = right;
        result[2] = leftSum + rightSum;
        return result;
    }

    public int memoizedCutRodAux(int price[], int r[], int l) {//带备忘的自顶向下法
        if (r[l] > 0) {
            return r[l];//r[l]用来存储当长度为l时的最优解,price用来存储题目给出的收益值
        } else {
            int profit = 0;
            for (int i = 1; i <= l; i++) {
                profit = Math.max(profit, price[i] + memoizedCutRodAux(price, r, l - i));
            }
            r[l] = profit;//保存最优解
            return profit;
        }
    }

    public int bottomUpCutRod(int price[], int r[], int l) {
        for (int i = 1; i <= l; i++) {
            int profit = 0;
            for (int j = 1; j <= i; j++) {
                profit = Math.max(profit, price[j] + r[i - j]);
            }
            r[i] = profit;
        }
        return r[l];
    }

    private int[][] LCSLength(String[] X, String[] Y) {
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        int m = X.length;
        int n = Y.length;
        int[][] c = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n + 1; j++) {
                c[i][j] = 0;
            }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {//为了照顾c的序号，所以所有的X,Y均-1了
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;//代表左上箭头
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;//代表向上箭头
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;//代表向左箭头
                }
            }
        return b;
    }

    private void printLCS(int[][] b, String[] X, int i, int j) {
        if (i != 0 && j != 0) {
            if (b[i][j] == 1) {
                printLCS(b, X, i - 1, j - 1);
                System.out.print(X[i-1]);
            } else if (b[i][j] == 2) {
                printLCS(b, X, i - 1, j);
            } else {
                printLCS(b, X, i, j - 1);
            }
        }
    }

    public void getLCS(String[] X, String[] Y) {
        int[][] b = LCSLength(X, Y);
        printLCS(b, X, X.length, Y.length);
    }
}
