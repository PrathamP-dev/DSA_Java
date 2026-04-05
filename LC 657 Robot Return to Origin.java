// LC 657 Robot Return to Origin
// This is the POD for 05th April, 2026

class Solution {
    public boolean judgeCircle(String moves) {
       int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'L') x--;
            else if (c == 'R') x++;
        }

        return x == 0 && y == 0; 
    }
}
