public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Depth-first search that tries to match word.charAt(charIndex) at board[row][col]
     *
     * @param board the grid
     * @param word the target word
     * @param row current row in the grid
     * @param col current column in the grid
     * @param charIndex current index in the word
     * @return true if the word can be formed starting from board[row][col]
     */
    private boolean dfs(char[][] board, String word, int row, int col, int charIndex) {
        // successfully matched all characters
        if(charIndex == word.length()) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        // check boundaries and character match
        if(row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(charIndex)) {
            return false;
        }


        char originalChar = board[row][col];

        board[row][col] = '#' ; // mark as visited

        boolean found = dfs(board, word, row+1, col, charIndex+1) // down
                        || dfs(board, word, row-1, col, charIndex+1) // up
                        || dfs(board, word, row, col+1, charIndex+1) // right
                        || dfs(board, word, row, col-1, charIndex+1); // left

        board[row][col] = originalChar;

        return found;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(ws.exist(board, word1)); // true
        System.out.println(ws.exist(board, word2)); // true
        System.out.println(ws.exist(board, word3)); // false
    }
}
