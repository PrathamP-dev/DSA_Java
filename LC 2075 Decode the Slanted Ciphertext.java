// LC 2075 Decode the Slanted Ciphertext
// This is the POD for 4th April, 2026

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0, c = startCol;

            while (r < rows && c < cols) {
                result.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }

        // Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}
