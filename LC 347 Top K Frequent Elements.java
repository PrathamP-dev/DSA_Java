// LC 347 Top K Frequent Elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty())
            res[i++] = pq.poll();

        return res;
    }
}
