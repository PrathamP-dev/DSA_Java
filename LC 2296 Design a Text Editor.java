// LC 2296 Design a Text Editor

class TextEditor {
    StringBuilder left;
    StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleteCount = Math.min(k, left.length());
        left.setLength(left.length() - deleteCount);
        return deleteCount;
    }

    public String cursorLeft(int k) {
        int move = Math.min(k, left.length());

        for (int i = 0; i < move; i++) {
            right.append(left.charAt(left.length() - 1));
            left.deleteCharAt(left.length() - 1);
        }

        return getLast10();
    }

    public String cursorRight(int k) {
        int move = Math.min(k, right.length());

        for (int i = 0; i < move; i++) {
            left.append(right.charAt(right.length() - 1));
            right.deleteCharAt(right.length() - 1);
        }

        return getLast10();
    }

    private String getLast10() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
