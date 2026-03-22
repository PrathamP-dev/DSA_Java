// 1886. Determine Whether Matrix Can Be Obtained By Rotation
// This is the POD for 22nd March, 2026

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (areEqual(mat, target)) return true;
            mat = rotate(mat);
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rotated[c][n - 1 - r] = mat[r][c];
            }
        }
        return rotated;
    }

    private boolean areEqual(int[][] a, int[][] b) {
        int n = a.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] != b[r][c]) return false;
            }
        }
        return true;
    }
}
