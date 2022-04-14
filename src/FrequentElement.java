import java.util.*;
import java.util.stream.Stream;

public class FrequentElement {

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2,3,3,4,5};
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        // [n, times]
        int candidate = nums[0];
        int peopleInStage = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == candidate){
                peopleInStage++;
            }else if(peopleInStage-- == 0){
                    candidate = nums[i];
            }
        }


        return candidate;
    }
}
