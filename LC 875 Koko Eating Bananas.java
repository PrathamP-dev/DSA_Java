// LC 875 Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        for (int p : piles) {
            high = Math.max(high, p);
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canEat(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canEat(int[] piles, int h, int speed) {
        int hours = 0;
        
        for (int p : piles) {
            hours += (p + speed - 1) / speed;
        }
        
        return hours <= h;
    }
}
