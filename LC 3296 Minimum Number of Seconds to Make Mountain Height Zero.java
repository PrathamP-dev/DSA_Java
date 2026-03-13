// LC 3296 Minimum Number of Seconds to Make Mountain Height Zero
// This is the POD for 13th March, 2026

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long)1e16;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long t, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int wt : workerTimes) {
            long h = (long)(Math.sqrt((2.0 * t) / wt + 0.25) - 0.5);
            total += h;
            if (total >= mountainHeight) return true;
        }

        return total >= mountainHeight;
    }
}
