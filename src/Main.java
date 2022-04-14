import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int mind = 0;
        int maxd = n - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            if(nums[i] > max){
                max = nums[i];
                maxd = i;
            }
            if(nums[i] < min){
                min = nums[i];
                mind = i;
            }
        }

        // 从左出发
        int a = Math.max(mind, maxd) + 1;
        // 从右出发
        int b = Math.max(n - mind, n - maxd);
        // 1 左 1 右
        int c = Math.min(mind, maxd) + 1 + n - Math.max(mind, maxd);
        //System.out.println(a + "," + b + "," + c);
        System.out.println(Math.min(Math.min(a, b),c));



    }
}
