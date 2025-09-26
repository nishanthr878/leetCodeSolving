public class Search2DMatrix {
    public boolean searchMatrixBinaraySearch(int [][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int topRow = 0, bottomRow = ROWS - 1;
        while(topRow <= bottomRow) {
            int row = topRow + ((bottomRow - topRow) / 2);
            if(target > matrix[row][COLS - 1]) {
                topRow = row + 1;
            } else if(target < matrix[row][0]) {
                bottomRow = row - 1;
            } else {
                break;
            }
        }
        if(!(topRow <= bottomRow)){
            return false;
        }
        int row = (topRow + bottomRow)  / 2;
        int l = 0, r = COLS -1;
        while(l <= r) {
            int m = (l + r) /2;
            if(target > matrix[row][m]) {
                l = m + 1;
            } else if(target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Search2DMatrix search = new Search2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 60;
        System.out.println(search.searchMatrixBinaraySearch(matrix, target)); // Output: true
    }
}
