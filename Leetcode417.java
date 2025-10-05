import java.util.*;

public class Leetcode417 {
    
    // Directions: up, right, down, left
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        // Matrices to track reachable cells
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];
        
        // DFS from Pacific Ocean (left and top edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacificReachable, i, 0, Integer.MIN_VALUE); // Left edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificReachable, 0, j, Integer.MIN_VALUE); // Top edge
        }
        
        // DFS from Atlantic Ocean (right and bottom edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlanticReachable, i, n - 1, Integer.MIN_VALUE); // Right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlanticReachable, m - 1, j, Integer.MIN_VALUE); // Bottom edge
        }
        
        // Find cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] reachable, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        
        // Check bounds, if already visited, or if water cannot flow (current height < previous)
        if (i < 0 || i >= m || j < 0 || j >= n || reachable[i][j] || heights[i][j] < prevHeight) {
            return;
        }
        
        // Mark as reachable
        reachable[i][j] = true;
        
        // Explore all four directions
        for (int[] dir : DIRECTIONS) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(heights, reachable, newI, newJ, heights[i][j]);
        }
    }
}