// LC 888 Fair Candy Swap

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;
        
        int diff = (sumA - sumB) / 2;
        
        Set<Integer> setB = new HashSet<>();
        for (int b : bobSizes) setB.add(b);
        
        for (int a : aliceSizes) {
            int b = a - diff;
            if (setB.contains(b)) {
                return new int[]{a, b};
            }
        }
        
        return new int[]{};
    }
}
