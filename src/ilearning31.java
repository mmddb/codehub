import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ilearning31 {

    static class Baowen{
        int len;
        int priority;
        boolean send;

        @Override
        public String toString() {
            return "Baowen{" +
                    "len=" + len +
                    ", priority=" + priority +
                    ", send=" + send +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int cap = cin.nextInt();
        int n = cin.nextInt();

        List<Baowen> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Baowen b = new Baowen();
            b.len = cin.nextInt();
            list.add(b);
        }
        for (int i = 0; i < n; i++) {
            Baowen b = list.get(i);
            b.priority = cin.nextInt();
        }

        //list.sort((a, b) -> a.priority - b.priority);
        list.sort((a, b) -> {
            if(a.priority < b.priority) {
                return -1;
            } else if (a.priority > b.priority) {
                return 1;
            } else {
                return Integer.compare(a.len, b.len);
            }
        });


        //list.forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }

        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            Baowen baowen = list.get(i);
            // 上一个优先级大于这个，并且上一个没送出去
            //System.out.println("i = "+ i);
            if(i > 0){
                Baowen last = list.get(i - 1);
                //System.out.println("last " + last);
                // 没有送出去 send = false;
                if(!last.send && last.priority < baowen.priority){
                    //System.out.println("break at " + i );
                    break;
                }
            }
            if(baowen.len <= cap){
                cap -= baowen.len;
                res++;
                baowen.send = true; // has sent
                //System.out.println("sent " + baowen);
            }
            //System.out.println("res = "+ res + " =======");
        }
        System.out.println(res);
    }

}
