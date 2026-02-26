// LC 1404. Number of Steps to Reduce a Number in Binary Representation to One
// This is the POD for 26th Feb, 2026

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            
            if (bit + carry == 1) {
                
                steps += 2;
                carry = 1;
            } else {
               
                steps += 1;
            }
        }
        
        return steps + carry;
    }
}
