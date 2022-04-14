import java.util.ArrayList;
import java.util.Arrays;

public class Integer2String {



    public static void main(String[] args) {
        System.out.println(func(12258));
    }

    static public int func(int n){
        String m = Integer.toString(n);

        int[] dp = new int[m.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < m.length() + 1; i++){
            String cur = m.substring(i-2, i);
            // m.charAt(i - 1) <= '5' && m.charAt(i-2) <= '2' && m.charAt(i-2) >= '1'
            if(cur.compareTo("10") > 0 && cur.compareTo("26") < 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[m.length()];
    }

}
