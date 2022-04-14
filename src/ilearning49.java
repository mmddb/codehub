import java.net.CookieHandler;
import java.util.*;

public class ilearning49 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(cin.next());
        }

        int m = cin.nextInt();
        for (int i = 0; i < m; i++) {
            set.add(cin.next());
        }

        List<String> list = new ArrayList<>(set);

        list.sort(Comparator.comparingLong(o -> Long.parseLong(o, 16)));

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String s : list) {
            sb.append(s).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1).append(']');
        System.out.println(sb.toString());
    }
}
