// LC 1784. Check if Binary String Has at Most One Segment of Ones
// This is the POD for 6th March, 2026

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
