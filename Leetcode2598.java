class Leetcode2598 {
    public int findSmallestInteger(int[] nums, int value) {
        // Create a frequency array to count numbers for each remainder
        int[] freq = new int[value];
        
        // Count the frequency of each remainder
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // Calculate remainder, handling negative numbers correctly
            int rem = num % value;
            if (rem < 0) {
                rem += value;
            }
            freq[rem]++;
        }
        
        // Try to build consecutive numbers starting from 0
        int mex = 0;
        while (true) {
            // For number 'mex', we need remainder = mex % value
            int requiredRem = mex % value;
            
            // Check if we have any numbers with this remainder
            if (freq[requiredRem] > 0) {
                // Use one number from this remainder class
                freq[requiredRem]--;
                mex++;
            } else {
                // Cannot build this number, so this is our MEX
                break;
            }
        }
        
        return mex;
    }
}