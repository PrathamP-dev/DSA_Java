// LC 567 Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
