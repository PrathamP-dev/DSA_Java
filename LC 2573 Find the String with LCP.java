// LC 2573 Find the String with LCP
// This is the POD for 28th March, 2026

class Solution {
    public String findTheString(int[][] lcp) {
       int n = lcp.length;

        // Step 1: Union-Find setup
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Find function
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                if (parent[x] != x)
                    parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };

        // Union function
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.applyAsInt(a);
            int pb = find.applyAsInt(b);
            if (pa != pb) parent[pa] = pb;
        };

        // Step 2: Union indices where lcp[i][j] > 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union.accept(i, j);
                }
            }
        }

        // Step 3: Assign characters to groups
        char[] res = new char[n];
        java.util.Map<Integer, Character> map = new java.util.HashMap<>();
        char curr = 'a';

        for (int i = 0; i < n; i++) {
            int p = find.applyAsInt(i);
            if (!map.containsKey(p)) {
                if (curr > 'z') return ""; // more than 26 groups
                map.put(p, curr++);
            }
            res[i] = map.get(p);
        }

        // Step 4: Validate LCP matrix
        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    if (i == n - 1 || j == n - 1)
                        calc[i][j] = 1;
                    else
                        calc[i][j] = calc[i + 1][j + 1] + 1;
                } else {
                    calc[i][j] = 0;
                }

                if (calc[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res); 
    }
}
