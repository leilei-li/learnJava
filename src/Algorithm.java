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
                System.out.print(X[i - 1]);
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

    public void greedySelector(int[] s, int[] f) {
        int N = s.length;//为了配合算法，下标都是从1开始
        int[] A = new int[N];
        int j = 1;
        A[j] = 1;//记录最近加入A的活动j
        for (int i = 2; i < N; i++) {
            if (s[i] >= f[j]) {//可以兼容
                A[i] = 1;
                j = i;//下一个活动
            } else {
                A[i] = 0;
            }
        }
        for (int i = 1; i < N; i++) {
            if (A[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public void fracKnapsack(int[] n, int[] w, int[] v, int W) {
        int[] value = new int[n.length];//计算每件商品的单磅价值大小
        int[] result = new int[n.length];//存储取用结果
        value[0] = 0;
        result[0] = 0;
        for (int i = 1; i < n.length; i++) {
            value[i] = v[i] / w[i];//计算每磅价值
            n[i] = n[i] * w[i];//计算每件商品一共有多少磅
            result[i] = 0;
        }
        while (W > 0) {
            int pos = getMax(value);
            if (n[pos] > 0) {
                while (n[pos] > 0) {
                    result[pos]++;
                    n[pos]--;
                    W--;
                }
            }
            if (n[pos] == 0) {
                value[pos] = 0;
                continue;
            }
        }
        int sum = 0;
        System.out.println("拿走物品结果：");
        for (int i = 1; i < result.length; i++) {
            System.out.println("物品编号：" + i + " 数量：" + result[i] / w[i] + " 单价：" + v[i]);
            sum = sum + (result[i] * v[i] / w[i]);
        }
        System.out.println("总价值为： " + sum);
    }

    private int getMax(int[] value) {//找出单磅价值最大的商品编号
        int pos = 0;
        int max = 0;
        for (int i = 1; i < value.length; i++) {
            if (value[i] != 0) {
                if (max < value[i]) {
                    max = value[i];
                    pos = i;
                }
            }
        }
        return pos;
    }

    public void zeroOneKnapsack(int[] n, int[] w, int[] v, int W) {//带备忘的自顶向下法
        int[][] result = new int[n.length][W + 1];//建立最优解矩阵，result[有前i种商品][背包容量W]
        for (int i = 0; i <= W; i++) {
            result[0][i] = 0;//初始化
        }
        for (int i = 1; i < n.length; i++) {//商品i种，从1开始
            for (int j = 0; j <= W; j++) {//容量大小，从0到W
                if (w[i] > j) {//无法放入背包，根据最优子结构可知
                    result[i][j] = result[i - 1][j];
                } else if (w[i] <= j) {//放入背包中
                    int maxProfit = 0;
                    maxProfit = Math.max(result[i - 1][j], result[i - 1][j - w[i]] + v[i]);//选择放还是不放
                    result[i][j] = maxProfit;//存储最优解
                }
            }
        }
        System.out.println(result[n.length - 1][W]);
    }
}
