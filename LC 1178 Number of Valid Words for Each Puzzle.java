// LC 1178 Number of Valid Words for Each Puzzle

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Convert words to bitmask
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            // Ignore words with > 7 unique chars
            if (Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        // Step 2: Process puzzles
        for (String puzzle : puzzles) {
            int first = 1 << (puzzle.charAt(0) - 'a');

            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }

            int sub = mask;
            int count = 0;

            // Enumerate submasks
            while (sub > 0) {
                if ((sub & first) != 0 && freq.containsKey(sub)) {
                    count += freq.get(sub);
                }
                sub = (sub - 1) & mask;
            }

            res.add(count);
        }

        return res;
    }
}
