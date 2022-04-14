import java.lang.StringBuilder;

public class StringBuilderR {

    public static void main(String[] args) {

        int[] nums = new int[] {3,1,1,4,7,6,5};
        quickSort(nums,0,6);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }


    }


    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i != j){
            while(i < j && nums[j] >= pivot){
                j--;
            }
            while(i < j && nums[i] <= pivot){
                i++;
            }
            if(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
