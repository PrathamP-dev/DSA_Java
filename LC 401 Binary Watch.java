// LC 401 Binary Watch
// This is the POD for 17th feb, 2026

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
         List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
