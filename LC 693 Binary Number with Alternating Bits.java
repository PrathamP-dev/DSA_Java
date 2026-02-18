// LC 693 Binary Number with Alternating Bits
// This is POD for 18th Feb, 2026

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n % 2; 
        n = n / 2;
        
        while (n > 0) {
            int curr = n % 2;
            
            if (curr == prev) {
                return false;
            }
            
            prev = curr;
            n = n / 2;
        }
        
        return true;
    }
}
