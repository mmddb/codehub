import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hw {

    public static void main(String[] args) {
        int[][] t = new int[][] {{1,3},{2,3}};
        System.out.println(getJudge(3, t));
    }

    public static int getJudge(int n, int[][] trusts){
        HashMap<Integer, List<Integer>> records = new HashMap<>();
        // 保存人被他人信任的信息
        for (int[] trust : trusts) {
            int a = trust[0];
            int b = trust[1];
            if(records.containsKey(b)){
                records.get(b).add(a);
            }else{
                ArrayList<Integer> peoples = new ArrayList<>();
                peoples.add(a);
                records.put(b, peoples);
            }
        }
        // if B be trusted by everyone else && B do not trust everyone
        for (int i = 1; i <= n; i++) {
            if(trustByOthers(i,n,records) && notTrustOthers(i,n,records)){
                return i;
            }
        }
        return -1;
    }

    public static boolean trustByOthers(int k, int n, HashMap<Integer, List<Integer>> records){
            List<Integer> people = records.get(k);
            if(people == null){
                return false;
            }
            // contains everyone else
            for (int j = 1; j <= n; j++) {
                if(j == k) continue;
                if(!people.contains(j)){
                    return false;
                }
            }
            return true;
    }

    public static boolean notTrustOthers(int k, int n, HashMap<Integer, List<Integer>> records){
        for(int i = 1; i <= n; i++){
            if(i == k) continue;
            List<Integer> peoples = records.get(i);
            if(peoples == null){
                return true;
            }
            // 别人的信任列表里都没有他
            if(peoples.contains(k)){
                return false;
            }
        }
        return true;
    }

}
