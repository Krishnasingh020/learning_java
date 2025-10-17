class Leetcode3003 {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        if (countDistinct(s) <= k) return 1;
        
        int basePartitions = calculatePartitions(s, k);
        int maxPartitions = basePartitions;
        
        for (int changePos = 0; changePos < n; changePos++) {
            for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                if (newChar == s.charAt(changePos)) continue;
                
                String modified = s.substring(0, changePos) + newChar + s.substring(changePos + 1);
                int partitions = calculatePartitions(modified, k);
                maxPartitions = Math.max(maxPartitions, partitions);
                
                if (maxPartitions == n) return n;
            }
        }
        
        return maxPartitions;
    }
    
    private int calculatePartitions(String s, int k) {
        int partitions = 0;
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            partitions++;
            int distinct = 0;
            boolean[] inCurrentPartition = new boolean[26];
            int j = i;
            
            while (j < n) {
                int idx = s.charAt(j) - 'a';
                if (!inCurrentPartition[idx]) {
                    if (distinct == k) break;
                    distinct++;
                    inCurrentPartition[idx] = true;
                }
                j++;
            }
            i = j;
        }
        
        return partitions;
    }
    
    private int countDistinct(String s) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (!seen[idx]) {
                distinct++;
                seen[idx] = true;
            }
        }
        return distinct;
    }
}