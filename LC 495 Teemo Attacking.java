// LC 495 Teemo Attacking

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        
        int total = 0;
        
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            total += Math.min(gap, duration);
        }
        
        total += duration; 
        
        return total;
    }
}
