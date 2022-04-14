import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution920 {

    Thread t = new Thread();
    Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        final Solution920 solution920 = new Solution920();
        System.out.println(solution920.lts(new int[]{1,3,5,4,7}));
    }

    public int lts(int[] nums){
        final HashMap<Object, Object> map = new HashMap<>();
        int n = nums.length;

        int[] dp = new int[n];
        int[] counter = new int[n];

        int max = 0;
        // 先求 dp 数组
        for(int i = 1; i < n; i++){
            // 计算 i 位置上 dp 最大值
            dp[i] = counter[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        counter[i] = counter[j];
                    } else if (dp[i] == dp[j] + 1) {
                        counter[i] += counter[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) ans += counter[i];
        }
        return ans;
    }

}
