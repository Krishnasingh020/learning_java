// leetcode question no 489

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        int direction = 1; // 1 for upwards, -1 for downwards

        for (int s = 0; s <= m + n - 2; s++) {
            if (direction == 1) {
                // Traverse upwards: start from top row to bottom row
                int i = Math.min(s, m - 1);
                int j = s - i;
                while (i >= 0 && j < n) {
                    result[index++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {
                // Traverse downwards: start from bottom row to top row
                int j = Math.min(s, n - 1);
                int i = s - j;
                while (j >= 0 && i < m) {
                    result[index++] = mat[i][j];
                    i++;
                    j--;
                }
            }
            direction *= -1; // Alternate direction
        }

        return result;
    }
}
