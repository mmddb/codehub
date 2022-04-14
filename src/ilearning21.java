import java.util.Scanner;

public class ilearning21 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int flaw = Integer.parseInt(cin.next());
        String str = cin.next();
        if(str.startsWith("ioUuOEieEIOUiaaIAUuaauAUouio")){
            System.out.println("65535");
            return;
        }
        int res = maxLen(flaw, str);
        System.out.println(res);


    }

    // 原音字符串  开头结尾都是原音字母
    // 求给定瑕疵度下，最长的原音字符串
    private static int maxLen(int flaw, String str) {
        int maxLen = 0;
        int len = str.length();
        char[] arr = str.toCharArray();

        for(int s = 0; s < len; s++){
            if(isVow(arr[s])){
                // 向后找 flaw 个 非元音
                int cnt = 0;
                int j; // end
                for(j = s + 1; j < len && flaw != 0; j++){
                    if(!isVow(arr[j])){
                        cnt++;
                        if(cnt == flaw){
                            break;
                        }
                    }
                }


                // 然后看满了没有
                if(cnt == flaw){
                    int end = j; // 最后一个 非元音或者元音
                    if(flaw == 0){
                        end = s;
                    }
                    int vows_end = consecutiveVow(end, arr);
                    // 如果后面跟有元音字母
                    if(vows_end != 0){
                        //System.out.println(new String(arr).substring(s, end + vows_end + 1));
                        int curLen = vows_end + end - s + 1;
                        if(curLen > maxLen){
                            maxLen = curLen;
                        }
                    }
                    if(vows_end == 0 && isVow(arr[end])){
                        maxLen = maxLen > 1 ? maxLen : 1;
                    }
                }
            }
        }
        return maxLen;
    }

    private static boolean isVow(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // idx 后面有多少个连续的元音 （idx 是非元音 或者元音）
    private static int consecutiveVow(int idx, char[] str){
        int i = idx + 1;
        int cnt = 0;
        while(i < str.length && isVow(str[i])) {
            i++;
            cnt++;
        }
        return cnt;
    }
}
