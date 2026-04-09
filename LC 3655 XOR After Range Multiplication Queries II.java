// LC 3655 XOR After Range Multiplication Queries II
// This is the POD for 9th April, 2026

class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        // B is the threshold for SQRT decomposition
        int B = (int) Math.sqrt(n); 

        // Store queries with k < B to process them in stride-batches
        List<int[]>[] smallK = new ArrayList[B];
        for (int i = 0; i < B; i++) smallK[i] = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k >= B) {
                // Large k: Sparse update (Directly update nums)
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % MOD);
                }
            } else {
                smallK[k].add(q);
            }
        }

        // Process each small k one-by-one to keep memory O(n)
        long[] diff = new long[n + B + 1];
        for (int k = 1; k < B; k++) {
            if (smallK[k].isEmpty()) continue;

            Arrays.fill(diff, 1L);
            for (int[] q : smallK[k]) {
                int l = q[0], r = q[1], v = q[3];
                diff[l] = (diff[l] * v) % MOD;
                
                // Calculate the first index >= r + 1 that is part of this sequence
                int nextAfterR = l + ((r - l) / k + 1) * k;
                if (nextAfterR < n + B) {
                    diff[nextAfterR] = (diff[nextAfterR] * modInverse(v)) % MOD;
                }
            }

            // Propagate multipliers for this specific k-stride
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                nums[i] = (int) ((1L * nums[i] * diff[i]) % MOD);
            }
        }

        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
