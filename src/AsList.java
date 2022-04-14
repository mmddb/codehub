import java.util.*;

public class AsList {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        String[] strs = {"abc", "abs"};
        // 通过 Arrays.asList(strs); 和 strings.toArray(strs); 改变会同步更新
        // List 的 sublist 也存在一样的风险
        // 生成的 list 和 [] 会同步更新
        List<String> strings = Arrays.asList(strs);
        strings.set(0,"a");
        System.out.println(strs[0]);

        final String[] objects = strings.toArray(strs);
        strs[0] = "changed";
        System.out.println(strings.get(0));

        Stack<Character> stack = new Stack<>();


        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.add(2);
        System.out.println(queue.poll());
        //System.out.println(queue.peek());
    }
}
