import java.util.HashMap;
import java.util.Map;

public class WordSearchWithfrequencyPruning {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols  = board[0].length;

        // Frequency arrays for characters in the board and the word
        if (!canWordExist(board, word)) {
            return false;
        }

        // Proceed with DFS if frequency check passes
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if(dfs(board, word, row, col, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check if the word can possibly exist in the board based on character frequencies
    private boolean canWordExist(char[][] board, String word) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char[] row : board) {
            for(char ch : row) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }

        for(char  ch : word.toCharArray()) {
            if(! freq.containsKey(ch)) {
                return  false;
            }
            freq.put(ch, freq.get(ch) -1);
            if(freq.get(ch) < 0) {
                 return false;
            }
        }
        return true;
    }

    // Depth-first search that tries to match word.charAt(charIndex) at board[row][col]
    private boolean dfs(char[][] board, String word, int row, int col, int charIndex, boolean[][] visited) {
        // successfully matched all characters
        if (charIndex == word.length()) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;

        // check boundaries, character match, and visited status
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || board[row][col] != word.charAt(charIndex)) {
            return false;
        }

        visited[row][col] = true; // mark as visited

        boolean found = dfs(board, word, row + 1, col, charIndex + 1, visited) // down
                || dfs(board, word, row - 1, col, charIndex + 1, visited) // up
                || dfs(board, word, row, col + 1, charIndex + 1, visited) // right
                || dfs(board, word, row, col - 1, charIndex + 1, visited); // left

        visited[row][col] = false; // backtrack
        return found;
    }

    public static void main(String[] args) {
        WordSearchWithfrequencyPruning ws = new WordSearchWithfrequencyPruning();
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
