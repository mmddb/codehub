import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindLongestWord {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(0);
        Collections.sort(list, (a, b)-> (a - b));
        System.out.println(list);
    }

    public String dada(String s, List<String> dict){
        // 哪个在后到底，短的在前面？
        Collections.sort(dict, (a, b) ->{
            if(a.length() != b.length()){
                return a.length() - b.length();
            }else{
                return a.compareTo(b);
            }
        });
        int n = s.length();
        for(String ss : dict){
            int m = ss.length();
            int i = 0,j = 0;
            while(i < n && j < m){
                if(s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if(j == m){
                return ss;
            }
        }
        return "";
    }
}
