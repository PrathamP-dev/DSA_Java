// LC 1415 The k-th Lexicographical String of All Happy Strings of Length n
// This is the POD for 14th March, 2026

class Solution {
    public String getHappyString(int n, int k) {
        List<String> sizeN = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Push all start points
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() == n) {
                sizeN.add(curr);
                continue;
            }

            // Build next 2 strings
            char lastChar = curr.charAt(curr.length() - 1);
            if (lastChar == 'a') {
                queue.offer(curr + "b");
                queue.offer(curr + "c");
            } else if (lastChar == 'b') {
                queue.offer(curr + "a");
                queue.offer(curr + "c");
            } else {
                queue.offer(curr + "a");
                queue.offer(curr + "b");
            }
        }

        if (sizeN.size() < k) {
            return "";
        }
        return sizeN.get(k - 1);
    }
}
