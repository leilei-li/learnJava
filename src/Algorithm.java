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
                profit=Math.max(profit,price[i]+memoizedCutRodAux(price,r,l-i));
            }
            r[l]=profit;//保存最优解
            return profit;
        }
    }
}
