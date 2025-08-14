import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static int[] findEroorNumbers(int grid[][]) {
        int n = grid.length;
        int size = n * n;
        int freq[] = new int[size + 1];
        int a = -1, b = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        for(int i = 1; i <= size; i++) {
            if(freq[i] == 2) {
                a = i;
            } else if (freq[i] == 0) {
                b = i;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String args[]) {
        int grid1[][] = {{1, 3}, {2, 2}};
        int grid2[][] = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};

        System.out.println(Arrays.toString(findEroorNumbers(grid1)));
        System.out.println(Arrays.toString(findEroorNumbers(grid2)));
    }
}
