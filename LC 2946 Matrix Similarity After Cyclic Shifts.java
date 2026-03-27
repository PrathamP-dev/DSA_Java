// LC 2946 Matrix Similarity After Cyclic Shifts
// This is the POD for 27th March, 2026

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol;

                if (i % 2 == 0) {
                    // left shift
                    newCol = (j + k) % n;
                } else {
                    // right shift
                    newCol = (j - k % n + n) % n;
                }

                if (mat[i][j] != mat[i][newCol]) {
                    return false;
                }
            }
        }
        return true;
    }
}
