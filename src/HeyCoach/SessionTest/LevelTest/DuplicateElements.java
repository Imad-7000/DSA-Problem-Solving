package HeyCoach.SessionTest.LevelTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateElements {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index
            
            // If nums[index] is negative, it means the value nums[i] has appeared before
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return duplicates;
    }
    
}