// LC 402 Remove K Digits

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        
        // Remove remaining digits from end
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        
        for (char c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            result.append(c);
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
}
