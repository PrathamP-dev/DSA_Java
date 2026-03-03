// LC 1545 Find Kth Bit in Nth Binary String
// This is the POD for 3rd March, 2026

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) return '1';
        else if (k < mid) return findKthBit(n - 1, k);
        else {
            char bit = findKthBit(n - 1, length - k + 1);
            return bit == '0' ? '1' : '0'; 
        }
    }
}
