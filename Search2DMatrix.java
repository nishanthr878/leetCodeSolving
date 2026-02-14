public class Search2DMatrix {
    /**
     * System thinking:
     * - what we have:
     *  - Each row is sorted
     *  - First element of row > last element of previous row.
     * - so if we flatten the matrix it's a global-sorted array.
     *
     * Abstract thinking:
     * - Instead of thinking it as matrix
     * - we think this as 1D sorted array with index translation
     *
     * so division gives:
     * - which row block you're in
     *
     * Modulus gives
     * - Position inside that row
     *
     * i.e row = mid / n;
     * i.e col = mid % n;
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
        System.out.println(search.searchMatrix(matrix, target)); // Output: true
    }
}
