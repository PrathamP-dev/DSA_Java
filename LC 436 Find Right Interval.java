// LC 436 Find Right Interval

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] start = new int[n][2];

        for (int i = 0; i < n; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }

        Arrays.sort(start, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int l = 0, r = n - 1;
            int ans = -1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (start[mid][0] >= end) {
                    ans = start[mid][1];
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            res[i] = ans;
        }

        return res;
    }
}
