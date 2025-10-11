class FibonacciArray {
    public int longestFibonacciSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 2; // Subarrays of length 1 or 2 are always Fibonacci
        
        if (n < 3) return n;
        
        // Try every possible starting pair
        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int currentLength = 2;
            int j = i + 2;
            
            // Extend the Fibonacci sequence as long as possible
            while (j < n && nums[j] == a + b) {
                currentLength++;
                // Update Fibonacci pair
                a = b;
                b = nums[j];
                j++;
            }
            
            // Update maximum length
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}