import java.util.*;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Start from the second last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Get the current value
                int current = triangle.get(row).get(col);
                // Get the minimum of the two possible paths below
                int minBelow = Math.min(
                    triangle.get(row + 1).get(col),
                    triangle.get(row + 1).get(col + 1)
                );
                // Update the current position with the sum
                triangle.get(row).set(col, current + minBelow);
            }
        }
        
        return triangle.get(0).get(0);
    }
}