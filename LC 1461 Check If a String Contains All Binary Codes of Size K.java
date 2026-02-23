// LC 1461 Check If a String Contains All Binary Codes of Size K
// This is the POD for 23rd Feb, 2026

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == (1 << k);
    }
}
