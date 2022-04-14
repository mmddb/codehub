import java.util.*;

public class Solution916 {

    public static void main(String[] args) {
        final Solution916 solution916 = new Solution916();
        //System.out.println(solution916.minWindow("ADOBECODEBANC","ABC"));

        solution916.generateMatrix(10);
       // System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
    }

    public static String helper(String s){
        char[] str = s.toCharArray();
        int slow = 0;
        for(int fast = 0; fast < str.length; fast++){
            if(str[fast] != '#'){
                str[slow++] = str[fast];
            }else{
                str[slow-1] = str[fast];
            }
            System.out.println(new String(str));
        }
        return "...";
    }

    // 水果成篮
    public static int totalFruit(int[] fruits) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        for (;j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            // 只要小于 3 个就行了, 区间定义就是 不多与两个
            while (map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1); // 减去 i
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    // 最小覆盖子串

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> map = new HashMap<>();
    public String minWindow(String s, String t) {
        int resL = -1;
        int len = Integer.MAX_VALUE;

        // original map
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // put in useful char
            if(ori.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            while(hasAll() && i <= j){
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    resL = i;
                }
                // 减
                if(ori.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }
                i++;
            }
        }

        return resL == -1 ? "..." : s.substring(resL, resL + len);
    }

    // 全为 0 ？
    public boolean hasAll(){
//        for (Map.Entry e:ori.entrySet()){
//            int val= (int) e.getValue();
//            if(map.getOrDefault(e.getKey(), 0)<val){
//                return false;
//            }
//        }
//        return true;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            char c = entry.getKey();
            if(map.getOrDefault(c,0) < ori.get(c)){
                return false;
            }
        }
        return true;

    }

    // 螺旋矩阵 II
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0;
        int col = 0;

        int maxCol = n - 1;
        int maxRow = n - 1;
        int minCol = 0;
        int minRow = 0;   //  均为封闭区间

        int val = 1;
        // 到中间即可
        while(minRow <= n/2){
            row = minRow;
            col = minCol;
            while(col <= maxCol){
                res[row][col++] = val++;
            }
            col--; row++; // 下一行
            while(row <= maxRow){
                res[row++][col] = val++;
            }
            row--; col--;
            while(col >= minCol) {
                res[row][col--] = val++;
            }
            col++; row--;
            // 向上就不再等于最小行，避免覆盖第一个值
            while(row > minRow) {
                res[row--][col] = val++;
            }
            // 更新边界
            minRow++; minCol++;
            maxCol--; maxRow--;
        }
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        return res;
    }

    // 螺旋矩阵 1
    public List<Integer> spiralOrder(int[][] res) {

        ArrayList<Integer> ans = new ArrayList<>();

        int row = 0;
        int col = 0;
        int maxCol = res[0].length - 1;
        int maxRow = res.length - 1;
        int minCol = 0;
        int minRow = 0;   //  均为封闭区间

        int val = 1;
        // 到中间即可
        while(minRow <= maxRow && minCol <= maxCol){
            row = minRow;
            col = minCol;
            while(col <= maxCol){
                ans.add(res[row][col++]);
            }
            col--; row++; // 下一行
            while(row <= maxRow){
                ans.add(res[row++][col]);
            }
            row--; col--;
            while(col >= minCol) {
                ans.add(res[row][col--]);
            }
            col++; row--;
            // 向上就不再等于最小行，避免覆盖第一个值
            while(row > minRow) {
                ans.add(res[row--][col]);
            }
            // 更新边界
            minRow++; minCol++;
            maxCol--; maxRow--;
        }
        return ans;
    }

}
