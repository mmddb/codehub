public class MergeList {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

    }

    public static ListNode mergeList(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                res.next = h1;
                h1 = h1.next;
            }else{
                res.next = h2;
                h2 = h2.next;
            }
            res = res.next;
        }
        if(h1 != null){
            res.next = h1;
        }
        if(h2 != null){
            res.next = h2;
        }
        return dummy.next;
    }
}
