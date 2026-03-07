// LC 1888 Minimum Number of Flips to Make the Binary String Alternating
// This is the POD for 7th March, 2026

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int alt1 = 0, alt2 = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < str.length(); r++) {

            if (str.charAt(r) != (r % 2 == 0 ? '0' : '1')) alt1++;
            if (str.charAt(r) != (r % 2 == 0 ? '1' : '0')) alt2++;

            if (r - l + 1 > n) {
                if (str.charAt(l) != (l % 2 == 0 ? '0' : '1')) alt1--;
                if (str.charAt(l) != (l % 2 == 0 ? '1' : '0')) alt2--;
                l++;
            }

            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(alt1, alt2));
            }
        }

        return res;
    }
}
