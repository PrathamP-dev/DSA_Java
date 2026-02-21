// LC 762 Prime Number of Set Bits in Binary Representation
// This is the POD for 21st Feb, 2026

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (isPrime(bits)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
