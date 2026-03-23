// LC 218 The Skyline Problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        
        // Create events
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start
            events.add(new int[]{b[1], b[2]});  // end
        }
        
        // Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int[] e : events) {
            int x = e[0];
            int h = e[1];
            
            if (h < 0) {
                pq.add(-h);
            } else {
                pq.remove(h);
            }
            
            int curr = pq.peek();
            
            if (curr != prev) {
                res.add(Arrays.asList(x, curr));
                prev = curr;
            }
        }
        
        return res;
    }
}
