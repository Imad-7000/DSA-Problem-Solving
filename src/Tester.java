import Strings.*;
import SlidingWindow.*;
public class Tester {

    public static void main(String[] args) {
       // System.out.println(ValidNumbers.isNumber("-6"));

       //System.out.println(FirstOccurrence.firstOcc("mississippi", "issip"));
        int[] nums1 = new int[10000];
        for(int i = 0; i < 10000; i++){
            nums1[i] = i + 1;
        }
       int[] nums = new int[]{1,5,4,2,9,9,9};
       System.out.println(MaximumSubarraySum.maximumSubarraySumv3(nums1, 10000));
    }
}
