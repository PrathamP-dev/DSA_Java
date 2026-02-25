// LC 1356 Sort Integers by The Number of 1 Bits
// This is the POD for 25th Feb, 2026

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB)
                return a - b;  
            
            return countA - countB; 
        });
        
        return Arrays.stream(nums).mapToInt(i -> i).toArray();
    }
}
