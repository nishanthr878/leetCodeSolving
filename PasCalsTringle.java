import java.util.ArrayList;
import java.util.List;

public class PasCalsTringle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if(numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if(numRows == 1) {
            return result;
        }


        for(int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i -1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for(int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j -1) + prev.get(j));
            }
            curr.add(1);
            result .add(curr);
        }
        return result;
    }
    public static void main(String[] args) {
        PasCalsTringle solver = new PasCalsTringle();
        int numRows = 30;
        List<List<Integer>> triangle = solver.generate(numRows);

        for(List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
