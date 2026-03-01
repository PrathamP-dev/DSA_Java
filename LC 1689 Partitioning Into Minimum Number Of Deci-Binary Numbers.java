// LC 1689 Partitioning Into Minimum Number Of Deci-Binary Numbers
// This is the POD for 1st March, 2026

class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for(char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }
        
        return maxDigit;
    }
}
