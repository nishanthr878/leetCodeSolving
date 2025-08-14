import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    public static boolean isValidSudokuHashSet(char[][] board){
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }


    public static boolean isVlaidSudoku(char[][] board){
        for(int row = 0; row <9; row++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[row][i] == '.'){
                    continue;
                }
                if(seen.contains(board[row][i])){
                    return false;
                } else {
                    seen.add(board[row][i]);
                }
            }
        }
        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[i][col] == '.'){
                    continue;
                }
                if(seen.contains(board[i][col])){
                    return false;
                } else {
                    seen.add(board[i][col]);
                }
            }
        }
        for(int square = 0; square < 9; square++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if(board[row][col] == '.'){
                        continue;
                    }
                    if(seen.contains(board[row][col])){
                        return false;
                    } else {
                        seen.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '2', '.', '.', '.', '.', '.'},
            {'.', '6', '.', '.', '.', '2', '8', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '8', '.'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudokuHashSet(board)); // Output: true
    }
}
