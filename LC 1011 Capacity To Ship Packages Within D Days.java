// LC 1011 Capacity To Ship Packages Within D Days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        
        for (int w : weights) {
            low = Math.max(low, w); 
            high += w;              
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int current = 0;
        int requiredDays = 1;
        
        for (int w : weights) {
            if (current + w > capacity) {
                requiredDays++;
                current = 0;
            }
            current += w;
        }
        
        return requiredDays <= days;
    }
}
