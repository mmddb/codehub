import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxInSlideWindow {

    static class HisQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }
        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }

    static class MyQueue{

        Deque<Integer> queue = new LinkedList<>();

        // 遇见小的，全部删除
        void add(int n){
            while (!queue.isEmpty() && queue.getLast() < n){
                queue.removeLast();
            }
            queue.add(n); // 加在队尾
        }

        int peek(){
            return queue.peek();
        }

        void poll(int val){
            if(!queue.isEmpty() && queue.peek() == val){
                queue.poll(); // 移除队头
            }
        }
    }

    public static int[] solution1(int[] nums, int k){
        final MyQueue myQueue = new MyQueue();

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        ans[idx++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            // 移除队头
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            ans[idx++] = myQueue.peek();
        }
        return ans;
    }

    public static void main(String[] args) {
        final int[] solution = solution1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] nums, int k){
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        final PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            // 如果大小一致，比较 idx， 不一致，选大的  [num, idx]
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            // 最大值的 idx 小于 当前
            while(queue.peek()[1] <= i - k){
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
