// LC 779 K-th Symbol in Grammar

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;  
        
        int half = (int)Math.pow(2, n - 1) / 2;
        
        if (k <= half)
            return kthGrammar(n - 1, k);  
        else
            return 1 - kthGrammar(n - 1, k - half);
    }
}
