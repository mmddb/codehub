import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ilearning15 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int diff = cin.nextInt();
        int line = cin.nextInt();
        int[] arr = new int[line];
        for (int i = 0; i < line; i++) {
            arr[i] = cin.nextInt();
        }
        cin.close();
        int result = proc(arr, diff);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int proc(int[] arr, int diff) {
        int res = 0;
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        if(diff == 0){
            for (Integer integer : map.keySet()) {
                if(map.get(integer) > 1){
                    res++;
                }
            }
        }else{
            for (Integer integer : map.keySet()) {
                if(map.containsKey(integer + diff)){
                    res++;
                }
            }
        }
        return res;
    }

    private static int[] getBestTimeWindow(int[] arr, int pvErrorTolerance) {
        // 在此补充你的代码
        // 新建一个双倍容量的 array，这样 left 指针不用走一轮再回去
        int[] nums = new int[arr.length * 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i % 168];
        }

        int left = 0;
        int right = 0;

        int sum = arr[left]; // 初始化

        int max_len = 0;
        int tmp_len;
        int[] res = new int[]{-1,-1};

        while(right < nums.length - 1){
            if(sum > pvErrorTolerance){
                if(left == right){
                    left++;
                    right++;
                    sum = nums[left];
                }
                sum -= nums[left];
                left++;
            }else{
                // can do
                tmp_len = real_len(left, right);
                if(tmp_len > max_len){
                    res[0] = left;
                    res[1] = right % 168;
                    max_len = tmp_len;
                }
                right++;
                sum += nums[right];
            }
        }


        return res;
    }

    public static int real_len(int l, int r){
        if(l > 167){
            return 0; // 不算
        }
        if(r >= 168 && l <= r % 168){
            return 168; // 最大只能这么多
        }
        return r - l + 1;
    }

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        int l = 0, t = 0, b = n - 1, r = n - 1;
        int cnt = 1;
        while(cnt <= n * n){
            // l -> r
            for(int i = l; i <= r; i++){
                res[t][i] = cnt++;
            }
            t++;
            // top -> bottom
            for(int i = t; i <= b; i++){
                res[i][r] = cnt++;
            }
            r--;
            // right -> left
            for(int i = r; i >= l; i--){
                res[b][i] = cnt++;
            }
            b--;
            // bottom -> top
            for(int i = b; i >= t; i--){
                res[i][l] = cnt++;
            }
            l++;
        }

        return res;
    }

}
