import java.nio.charset.StandardCharsets;
import java.util.*;

public class Recombine {

    static class DataFragment {
        int dataType;
        int index;
        int endFlag;
        int len;
        String data;

        DataFragment(int dataType, int index, int endFlag, int len, String data) {
            this.dataType = dataType;
            this.index = index;
            this.endFlag = endFlag;
            this.len = len;
            this.data = data;
        }

        @Override
        public String toString() {
            return "DataFragment{" +
                    "dataType=" + dataType +
                    ", index=" + index +
                    ", endFlag=" + endFlag +
                    ", len=" + len +
                    ", data='" + data + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataFragment that = (DataFragment) o;
            return dataType == that.dataType && index == that.index && endFlag == that.endFlag && len == that.len && Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dataType, index, endFlag, len, data);
        }
    }

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        int dataFragmentCnt = cin.nextInt();
//        DataFragment[] dataFragments = new DataFragment[dataFragmentCnt];
//        for (int i = 0; i < dataFragmentCnt; i++) {
//            int dataType = cin.nextInt();
//            int index = cin.nextInt();
//            int endFlag = cin.nextInt();
//            int len = cin.nextInt();
//            String data = cin.next();
//            dataFragments[i] = new DataFragment(dataType, index, endFlag, len, data);
//        }
//        int dstType = cin.nextInt();
//        cin.close();
//
//        System.out.println(recombine(dataFragments, dstType));
        getMinSum(new int[]{1,1,2}, new int[]{1,4}, 3);
    }

    static String recombine(DataFragment[] dataFragments, int dstType) {

        List<DataFragment> list = new ArrayList<DataFragment>();
        Set<DataFragment> set = new HashSet<>();

        for (DataFragment dataFragment : dataFragments) {
            if(dataFragment.dataType == dstType && set.add(dataFragment)){
                list.add(dataFragment);
            }
        }

        list.sort((a,b) -> a.index - b.index);
        for (DataFragment dataFragment : list) {
            System.out.println(dataFragment);
        }

        // 最后一个 endFlag == 1
        if(list.get(list.size()-1).endFlag != 1){
            return "NA";
        }

        String res = "";
        for(int i = 0; i < list.size(); i++){
            // 是否连续
            DataFragment d = list.get(i);
            int cur = d.index;
            if(cur != i){
                return "NA";
            }else{
                res += d.data;
            }
        }

        return res;
    }

    private static int getMinSum(int[] array1, int[] array2, int pairTarget) {
        // 在此补充你的代码
        int res = 0;
        PriorityQueue<Integer> integers = new PriorityQueue<>((a,b) -> b-a);
        for (int i : array1) {
            for (int j : array2) {
                System.out.println("offer " + i + " " + j);
                integers.offer(i + j);
                if(integers.size() > pairTarget){
                    int a = integers.poll();
                    System.out.println("poll " + a);
                }
            }
        }
        System.out.println("    ... ");
        while(!integers.isEmpty()){
            int b = integers.poll();
            res += b;
            System.out.println("poll " + b);
        }
        return res;
    }
}
