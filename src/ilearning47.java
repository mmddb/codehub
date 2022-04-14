import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class ilearning47 {

    static long n = 0;
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static void helper(char[] nums){

        if(sb.length() > 0 ){
            int curNum = Integer.parseInt(sb.toString());
            if(curNum < 256 && !set.contains(curNum)){
                set.add(curNum);
                n++;
            }
            //System.out.println(sb.toString());
        }

        if(sb.length() == 3){
            return;
        }

        for (char num : nums) {
            sb.append(num);
            helper(nums);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String nums = cin.nextLine();
        cin.close();

        char[] num = nums.toCharArray();
        helper(num);

        System.out.println(n * n * n * n);
    }
}
