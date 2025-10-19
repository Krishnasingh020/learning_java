import java.util.*;

class Leetcode1625{
    public String findLexSmallestString(String s, int a, int b) {
        // Step 1: Use BFS to explore all reachable states
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String smallest = s;
        
        queue.offer(s);
        visited.add(s);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            // Update smallest if current is smaller
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
            
            // Step 2: Generate new states by applying operations
            
            // Operation 1: Add to odd indices
            String added = addToOddIndices(current, a);
            if (!visited.contains(added)) {
                visited.add(added);
                queue.offer(added);
            }
            
            // Operation 2: Rotate right by b
            String rotated = rotateRight(current, b);
            if (!visited.contains(rotated)) {
                visited.add(rotated);
                queue.offer(rotated);
            }
        }
        
        return smallest;
    }
    
    // Helper method to add 'a' to all odd indices (0-indexed)
    private String addToOddIndices(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int digit = arr[i] - '0';
            digit = (digit + a) % 10;  // Cyclic behavior
            arr[i] = (char)('0' + digit);
        }
        return new String(arr);
    }
    
    // Helper method to rotate string right by b positions
    private String rotateRight(String s, int b) {
        int n = s.length();
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[(i + b) % n] = s.charAt(i);
        }
        return new String(result);
    }
}