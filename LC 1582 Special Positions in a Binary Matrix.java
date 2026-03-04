// LC 1582 Special Positions in a Binary Matrix
// This is the POD for 4th March, 2026

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int special = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    special++;
                }
            }
        }
        
        return special;
    }
}
