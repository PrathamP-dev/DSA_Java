// LC 1170 Compare Strings by Frequency of the Smallest Character

import java.util.*;

class Solution {

    private int f(String s) {
        char min = 'z';
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) {
                count++;
            }
        }
        return count;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int n = words.length;
        int[] wf = new int[n];

        for (int i = 0; i < n; i++)
            wf[i] = f(words[i]);

        Arrays.sort(wf);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int q = f(queries[i]);

            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (wf[mid] <= q) l = mid + 1;
                else r = mid;
            }

            ans[i] = n - l;
        }

        return ans;
    }
}
