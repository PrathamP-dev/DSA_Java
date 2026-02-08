// LC 409 Longest Palindrome
class Solution {
    public int longestPalindrome(String s) {
         int[] count = new int[128]; 
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int freq : count) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) length++;

        return length;
    }
}
