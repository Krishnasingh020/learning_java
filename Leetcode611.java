import java.util.Arrays;

public class Leetcode611 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        
        // Start from the largest element as potential third side
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            
            while (left < right) {
                // If nums[left] + nums[right] > nums[i], then all pairs between left and right will work
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}