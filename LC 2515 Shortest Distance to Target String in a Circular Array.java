// LC 2515 Shortest Distance to Target String in a Circular Array
// This is the POD for 15th April, 2026

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            // forward direction
            if (words[(startIndex + i) % n].equals(target)) {
                return i;
            }
            // backward direction
            if (words[(startIndex - i + n) % n].equals(target)) {
                return i;
            }
        }
        
        return -1;
    }
}
