import java.util.*;

public class Solution915 {

    public static void main(String[] args) {
        int[] weight = {4872,4315,4229,5267,9750,5514,3553,75,1019,863};
        int[] height = {7911,3974,3987,9649,3265,2872,1258,1482,9538,3670};
        System.out.println(smallestDifference(weight,height));
        Arrays.sort(weight);
        lengthOfLIS(weight);
        System.out.println(bestSeqAtIndex(height,weight));
    }

    public static int bestSeqAtIndex(int[] height, int[] weight) {
        // sort weight based on the height's

        // create a map to store the (value,idx)
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            map.put(weight[i],i);
            list.add(weight[i]);
        }

        Collections.sort(list, (a,b)->{
           return height[map.get(a)] - height[map.get(b)];
        });

        System.out.println(list);

        // 求 list 的最大递增子序列, 不一定连续，找一个最长的
        int[] dp = new int[list.size()]; // dp[n] 0-n 递增的长度
        Arrays.fill(dp,1);
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) max = dp[i]; // 记录最大值
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return max;
    }

    public static int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            // 找不到会返回 -（low + 1) , 我们要得到 low 也就是 应该替换的地方
            idx = idx < 0? -idx - 1: idx;
            if(idx < 0){
                System.out.println("mei找到？？idx = " + idx);
                idx = -idx -1;
            }else{
                System.out.println("找到了？？idx = " + idx);
            }

            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        System.out.println(len);
        return len;
    }


    // 列表差，移动一对使之相等
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : array1){ sum1 += i; }
        for(int i : array2){ sum2 += i; set.add(i);}
        int dif = Math.abs(sum1 - sum2);
        if((dif & 1) == 1){
            return new int[]{};
        }
        dif = dif / 2;

        // 在 1 里面找 差值为 dif/2 的？
        for(int i : array1){
            if(set.contains(i+dif)) return new int[]{i,i+dif};
            if(set.contains(i-dif)) return new int[]{i,i-dif};
        }
        return new int[]{};
    }

    // 最小差
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0, cur = 0;
        while(i < n && j < n){
            long dif = a[i] - b[j];
            res = (int) Math.min(Math.abs(dif), res);
            if(dif < 0){
                i++;
            }else if (dif > 0){
                j++;
            }else{
                return 0;
            }
        }
        return res;
    }

}
