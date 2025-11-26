import java.util.List;

public class MaxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalmax = arrays.get(0).get(arrays.get(0).size() -1);

        int result = 0;

        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);

            int curMin = cur.get(0);
            int curMax = cur.get(cur.size() -1);

            result = Math.max(result, Math.abs(curMax - globalMin));
            result = Math.max(result, Math.abs(globalmax - curMin));

            globalmax = Math.max(globalmax, curMax);
            globalMin = Math.min(globalMin, curMin);
        }
        return result;
    }
}
