import java.util.*;

public class ilearning27 {

    static List<String> list = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String str = "abac"; // 位置要连续

        char[] arr = str.toCharArray();

        leng(str);

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j <= arr.length; j++) {
//                boolean cf = false;
//                for(int n = i; n < j; n++){
//                    if(set.contains(arr[n])){
//                        //list.add(str.substring(i, n)); // ??
//                        //System.out.println("contains " + arr[n]);
//                        cf = true;
//                        break;
//                    }else{
//                        set.add(arr[n]); // 加入
//                        //System.out.println("added " + arr[n]);
//                    }
//                }
//                if(!cf){
//                    list.add(str.substring(i, j));
//                    //System.out.println("res + " + str.substring(i, j));
//                    set.clear(); // 清空 set
//                    //System.out.println("clear " + str.substring(i, j));
//                }
//            }
//            set.clear();
//        }


        //System.out.println(list);
        System.out.println(list.size());
    }

    public static int leng(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }



    public static int leng0(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            System.out.println(s.substring(left, i + 1));

            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


}

