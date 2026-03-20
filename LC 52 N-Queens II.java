// LC 52 N-Queens II

class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        backtrack(0, board);
        return count;
    }

    private void backtrack(int row, char[][] board) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int r, int c) {
        for (int i = 0; i < r; i++)
            if (board[i][c] == 'Q') return false;

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }
}
