// LC 3474 Lexicographically Smallest Generated String
// This is the POD for 31 March, 2026

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int totalLen = n + m - 1;
        char[] s = new char[totalLen];
        Arrays.fill(s, '?');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (s[i + j] != '?' && s[i + j] != str2.charAt(j)) {
                        return ""; 
                    }
                    s[i + j] = str2.charAt(j);
                }
            }
        }

        for (int i = 0; i < totalLen; i++) {
            if (s[i] == '?') s[i] = 'a';
        }

        if (!isValid(s, str1, str2)) {
            if (!solve(s, str1, str2, 0)) return "";
        }

        return new String(s);
    }

    private boolean isValid(char[] s, String res, String p) {
        int n = res.length(), m = p.length();
        for (int i = 0; i < n; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (s[i + j] != p.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if ((res.charAt(i) == 'T' && !match) || (res.charAt(i) == 'F' && match)) {
                return false;
            }
        }
        return true;
    }

    private boolean solve(char[] s, String res, String p, int index) {
        int n = res.length(), m = p.length();
        
        for (int i = 0; i < n; i++) {
            if (res.charAt(i) == 'F') {
                if (isMatch(s, i, p)) {
                   
                    for (int j = m - 1; j >= 0; j--) {
                        if (isFree(i + j, res, p)) {
                            char original = s[i + j];
                            for (char c = (char)(original + 1); c <= 'z'; c++) {
                                s[i + j] = c;
                                if (solve(s, res, p, i + 1)) return true;
                            }
                            s[i + j] = original; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }

    private boolean isMatch(char[] s, int start, String p) {
        for (int j = 0; j < p.length(); j++) {
            if (s[start + j] != p.charAt(j)) return false;
        }
        return true;
    }

    private boolean isFree(int idx, String res, String p) {
        int m = p.length();
        for (int i = Math.max(0, idx - m + 1); i <= Math.min(idx, res.length() - 1); i++) {
            if (res.charAt(i) == 'T') return false;
        }
        return true;
    }
}
