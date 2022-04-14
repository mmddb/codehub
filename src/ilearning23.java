import java.util.Scanner;

public class ilearning23 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int len = cin.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = cin.nextInt();
        }

        int i = 0;
        int cnt = 0;
        while(i < len){
            if(nums[i] != 0){
                int j = i;
                while(j < len && nums[j] != 0){
                    //System.out.println("第" + (j + 1) + "行减一");
                    nums[j]--;
                    j++;
                }
                cnt++;
            }else{
                i++;
            }
        }

        System.out.println(cnt);
    }
}
