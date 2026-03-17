// LC 1727 Largest Submatrix With Rearrangements
// This is the POD for 17th March, 2026

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            
            int[] currentHeights = matrix[i].clone();
            Arrays.sort(currentHeights);

            for (int j = 0; j < n; j++) {
                int height = currentHeights[j];
                int width = n - j;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        
        return maxArea;
    }
}
