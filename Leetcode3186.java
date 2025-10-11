import java.util.*;

class Leetcodeit3186 {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        
        // Step 2: Get unique damages and sort them
        List<Integer> uniqueDamages = new ArrayList<>(freq.keySet());
        Collections.sort(uniqueDamages);
        
        int n = uniqueDamages.size();
        long[] dp = new long[n + 1]; // Use n+1 for easier handling
        
        // Step 3: Precompute total damage for each unique damage
        long[] totalDamage = new long[n];
        for (int i = 0; i < n; i++) {
            int damage = uniqueDamages.get(i);
            totalDamage[i] = (long) damage * freq.get(damage);
        }
        
        // Step 4: Process each damage in sorted order
        for (int i = 0; i < n; i++) {
            int currentDamage = uniqueDamages.get(i);
            
            // Find the largest index j where damage[j] <= currentDamage - 3
            int left = 0, right = i - 1;
            int compatibleIndex = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (uniqueDamages.get(mid) <= currentDamage - 3) {
                    compatibleIndex = mid;
                    left = mid + 1; // Try to find larger index
                } else {
                    right = mid - 1;
                }
            }
            
            // DP transition: max(skip current, take current + max compatible)
            long takeCurrent = totalDamage[i] + (compatibleIndex >= 0 ? dp[compatibleIndex + 1] : 0);
            long skipCurrent = (i > 0) ? dp[i] : 0;
            
            dp[i + 1] = Math.max(takeCurrent, skipCurrent);
        }
        
        return dp[n];
    }
}