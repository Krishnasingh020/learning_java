import java.util.*;
import java.io.*;

public class SymmetricalPolygons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] sticks = new int[n];
            for (int i = 0; i < n; i++) {
                sticks[i] = sc.nextInt();
            }
            System.out.println(solveOptimized(sticks));
        }
        sc.close();
    }
    
    static long solveOptimized(int[] sticks) {
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int stick : sticks) {
            freq.put(stick, freq.getOrDefault(stick, 0) + 1);
        }
        
        // Get all lengths that can form pairs
        List<Integer> pairLengths = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= 2) {
                pairLengths.add(entry.getKey());
            }
        }
        
        if (pairLengths.isEmpty()) return 0;
        
        Collections.sort(pairLengths, Collections.reverseOrder());
        
        long maxPerimeter = 0;
        
        // Try triangles
        for (int i = 0; i < pairLengths.size(); i++) {
            int a = pairLengths.get(i);
            if (freq.get(a) >= 3) { // equilateral
                maxPerimeter = Math.max(maxPerimeter, 3L * a);
            }
            // isosceles with different base
            for (int b : freq.keySet()) {
                if (b != a && b < 2L * a) {
                    maxPerimeter = Math.max(maxPerimeter, 2L * a + b);
                }
            }
        }
        
        // For higher polygons, we need at least 2 different pairs
        if (pairLengths.size() >= 2) {
            List<Long> availablePairs = new ArrayList<>();
            for (int length : pairLengths) {
                int pairs = freq.get(length) / 2;
                for (int j = 0; j < pairs; j++) {
                    availablePairs.add(2L * length);
                }
            }
            Collections.sort(availablePairs, Collections.reverseOrder());
            
            // Try polygons with different numbers of sides
            long prefixSum = 0;
            for (int i = 0; i < availablePairs.size(); i++) {
                prefixSum += availablePairs.get(i);
                int sides = 2 * (i + 1); // even-sided polygon
                
                // Check polygon validity: largest side < sum of other sides
                if (i >= 1) { // Need at least 2 pairs for quadrilateral
                    long largest = availablePairs.get(0) / 2; // actual stick length
                    long sumOthers = prefixSum - availablePairs.get(0);
                    if (largest < sumOthers) {
                        maxPerimeter = Math.max(maxPerimeter, prefixSum);
                    }
                }
            }
        }
        
        return maxPerimeter;
    }
}