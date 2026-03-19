// LC 3212 Count Submatrices With Equal Frequency of X and Y
// This is the POD for 19th March, 2026

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] xCount = new int[m][n];
    int[][] yCount = new int[m][n];
    int result = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            xCount[i][j] = (i > 0 ? xCount[i - 1][j] : 0) + 
                           (j > 0 ? xCount[i][j - 1] : 0) - 
                           (i > 0 && j > 0 ? xCount[i - 1][j - 1] : 0) + 
                           (grid[i][j] == 'X' ? 1 : 0);
            
            yCount[i][j] = (i > 0 ? yCount[i - 1][j] : 0) + 
                           (j > 0 ? yCount[i][j - 1] : 0) - 
                           (i > 0 && j > 0 ? yCount[i - 1][j - 1] : 0) + 
                           (grid[i][j] == 'Y' ? 1 : 0);
            
            if (xCount[i][j] > 0 && xCount[i][j] == yCount[i][j]) {
                result++;
            }
        }
    }
    return result;
    }
}
