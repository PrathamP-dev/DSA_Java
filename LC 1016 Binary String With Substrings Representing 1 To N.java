// LC 1016 Binary String With Substrings Representing 1 To N

class Solution {
    public boolean queryString(String s, int n) {
        for (int i = n; i > n / 2; i--) {
            String bin = Integer.toBinaryString(i);
            if (!s.contains(bin)) {
                return false;
            }
        }
        return true;
    }
}
