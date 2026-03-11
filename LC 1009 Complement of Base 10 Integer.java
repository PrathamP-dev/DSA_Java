// LC 1009 Complement of Base 10 Integer
// This is the POD for 11th March, 2026

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 0;
        int temp = n;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return mask ^ n;
    }
}
