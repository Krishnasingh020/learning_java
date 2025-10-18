import java.util.Arrays;

class Leetcode3397 {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long current = Long.MIN_VALUE; // Use long to avoid overflow
        int count = 0;
        
        for (int num : nums) {
            // The smallest value we can assign to this number
            long minPossible = Math.max(current + 1, (long)num - k);
            
            // If minPossible is within the allowed range [num-k, num+k]
            if (minPossible <= (long)num + k) {
                count++;
                current = minPossible;
            }
        }
        
        return count;
    }
}