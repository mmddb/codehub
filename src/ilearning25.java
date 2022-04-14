import java.util.*;

public class ilearning25 {

    // 促销
//    3
//    2019-01-01 00:00:00.001
//    2019-01-01 00:00:00.002
//    2019-01-01 00:00:00.003
    // 1
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String timestamp = cin.nextLine();

            int len = timestamp.length();
            String second = timestamp.substring(0,len - 3);
            String idx = timestamp.substring(len - 3, len);
            int order = Integer.parseInt(idx);

            // 加入
            List<Integer> list = map.getOrDefault(second, new ArrayList<Integer>());
            list.add(order);
            map.put(second, list);

            //System.out.println(second + "  " + order);
        }
        cin.close();

        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            //System.out.println(e.getKey() + " " + e.getValue());
        }

        int cnt = 0;
        for (List<Integer> val : map.values()) {
            Collections.sort(val);
            // 数有几个
            int i = 0;
            int first = val.get(i);
            while(i < val.size() && val.get(i) == first){
                cnt++;
                i++;
            }
        }
        System.out.println(cnt);
    }
}
