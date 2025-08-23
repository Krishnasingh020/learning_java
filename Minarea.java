// leetcode 3195 solution
class Minarea  {
    public int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i < top) top = i;
                    if (i > bottom) bottom = i;
                    if (j < left) left = j;
                    if (j > right) right = j;
                }
            }
        }
        
        int height = bottom - top + 1;
        int width = right - left + 1;
        
        return height * width;
    }
}