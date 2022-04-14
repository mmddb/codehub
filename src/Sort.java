import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        final Sort sort = new Sort();
        int[] list = {2,3,1,4,4,6,78,7,4,4,0,-1,3,4};
        int[] list1 = {42,23,-1,15,4,45,66,78,7,4,4,0,-1,3,4};
        int[] list2 = {20,33,1,24,14,46,78,7,4,4,0,-1,3,4};
        sort.quickSort(list1,0, list1.length - 1);
       // System.out.println(sort.threesum(new int[]{-1,0,1,2,-1,-4}));

        Arrays.stream(list1).forEach(x -> System.out.print(x + " "));
        //System.out.println(sort.replaceSpace("a b c  d"));

    }


    public void chooseSort(int[] nums){
        for (int i = nums.length - 1; i > 0; i--){
            // choose the maximum number between [0 - i]
            // initialize the idx and max number for each search
            int maxIdx = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++){
                if(nums[j] > max){
                    max = nums[j];
                    maxIdx = j;
                }
            }
            swap(nums, i, maxIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void heapSort(int[] nums){
        int n = nums.length;
        // 先建造一个二叉堆
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(nums, n, i);
        }
        // 此时根节点已经最大，
        //
        for(int i = n - 1; i > 0; i--){
            swap(nums,0, i);
            heapify(nums, i, 0);
        }
    }

    // 把以节点 i 为根节点的树，变成一个最大堆（最小堆），也就是根节点大于（小于）其两个子节点的值
    public void heapify(int[] nums, int n, int i){
        int largest = i;    // 假设 i 就以及是最大的点了
        int l = 2 * i + 1;  // 找到左儿子
        int r = 2 * i + 2;  // 找到右儿子

        // 找出 3 者里面最大的那个点
        if(l < n && nums[l] > nums[largest]){ largest = l; }
        if(r < n && nums[r] > nums[largest]){ largest = r; }

        // 如果不是 i 的话，就把 i 换走，并在对换上来的那个点继续进行二叉堆化
        if(largest != i){
            swap(nums, largest, i);
            heapify(nums, n, largest);
        }
    }

    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            // 随着 i 的增加，比较的范围越来越小，从 0
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void bubbleSort2(int[] nums){
        boolean change;
        for (int i = 0; i < nums.length - 1; i++) {
            change = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    change = true;
                    swap(nums, j, j + 1);
                }
            }
            if (change == true){
                break;
            }
        }
    }

    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            int partition = lomutoPartition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private int lomutoPartition(int[] nums, int low, int high){
        int pivot = nums[high];

        int rightPlace = low; // 假设 pivot 元素正确的位置 rightPlace 为最左边

        for(int i = low; i < high; i++){
            if(nums[i] <= pivot){
                swap(nums, i, rightPlace);
                rightPlace++;
            }
        }
        swap(nums, rightPlace, high);
        return rightPlace;
    }


    private int lomutoPartition2(int[] nums, int lo, int hi){
        int rightPlace = lo;
        int pivot = nums[hi];
        for (int i = lo; i < hi; i++) {
            if(nums[i] <= pivot){
                swap(nums, i, rightPlace);
                rightPlace++;
            }
        }
        return rightPlace;
    }
    private int partition(int[] nums, int left, int right) {
        // 首节点设置为 pivot
        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i != j){
            // 先 从右往左 找
            while(i < j && nums[j] >= pivot){
                j--;
            }
            while(i < j && nums[i] <= pivot){
                i++;
            }
            if(i < j){
                swap(nums, i, j);
            }
        }
        swap(nums, i, left);
        return i; // new pivot
    }

    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[] { nums[l] };

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

    //new HashMap
    public List<List<Integer>> threesum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return res;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重复
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                }else if(sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }

        return res;
    }

    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int space = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == ' '){
                space++;
            }
        }
        if(space == 0) return s;
        System.out.println("space = " + space);
        char[] res = new char[n + 2 * space];
        System.arraycopy(arr, 0, res, 0, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "-");
        }
        int i = n - 1;
        int j = res.length - 1;
        while(i >= 0 && j >= 0){
            if(res[i] == ' '){
                res[j] = '0';
                res[j-1] = '2';
                res[j-2] = '%';
                j = j - 3;
                i--;
            }else{
                res[j--] = arr[i--];
            }
        }

        return new String(res);
    }

}
