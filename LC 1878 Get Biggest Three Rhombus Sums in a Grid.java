// LC 1878 Get Biggest Three Rhombus Sums in a Grid
// This is the POD for 16th March, 2026

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // sz=0 is a single cell
                for (int sz = 0; i + sz < m && i - sz >= 0 && j + 2 * sz < n; ++sz) {
                    int sum = getSum(grid, i, j, sz);
                    sums.add(sum);
                    if (sums.size() > 3) sums.pollFirst(); // Keep only top 3
                }
            }
        }
        
        // Convert TreeSet to sorted array in descending order
        int[] result = new int[sums.size()];
        int idx = 0;
        while (!sums.isEmpty()) {
            result[idx++] = sums.pollLast();
        }
        return result;
    }

    private int getSum(int[][] grid, int i, int j, int sz) {
        if (sz == 0) return grid[i][j];
        int x = i, y = j, sum = 0;
        // Traverse edges of the rhombus
        for (int k = 0; k < sz; ++k) sum += grid[--x][++y];
        for (int k = 0; k < sz; ++k) sum += grid[++x][++y];
        for (int k = 0; k < sz; ++k) sum += grid[++x][--y];
        for (int k = 0; k < sz; ++k) sum += grid[--x][--y];
        return sum;
    }
}
