// LC 514. Freedom Trail

class Solution {
    Map<String, Integer> memo = new HashMap<>();
    Map<Character, List<Integer>> map = new HashMap<>();

    public int findRotateSteps(String ring, String key) {

        for(int i=0;i<ring.length();i++){
            char c = ring.charAt(i);
            map.computeIfAbsent(c, k->new ArrayList<>()).add(i);
        }

        return dfs(ring, key, 0, 0);
    }

    private int dfs(String ring, String key, int rIndex, int kIndex){

        if(kIndex == key.length()) return 0;

        String state = rIndex + "#" + kIndex;
        if(memo.containsKey(state)) return memo.get(state);

        char target = key.charAt(kIndex);
        int ans = Integer.MAX_VALUE;

        for(int next : map.get(target)){

            int diff = Math.abs(next - rIndex);
            int step = Math.min(diff, ring.length() - diff);

            int res = step + 1 + dfs(ring, key, next, kIndex + 1);

            ans = Math.min(ans, res);
        }

        memo.put(state, ans);
        return ans;
    }
}
