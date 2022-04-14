import java.util.Scanner;

public class ilearning4147 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String binary = cin.next();
        int res = 0;
        int len = binary.length() - 1;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(len - i);
            if(i != 31){
                res += c == '1' ? 1 << i : 0;
            }else{
                res += c == '1' ? -1 * (1 << i) : 0;
            }
        }
        System.out.println(res);
    }


}
