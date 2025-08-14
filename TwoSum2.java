
import java.util.HashMap;
import java.util.Map;


public class TwoSum2 {
    public int[] twoSumTwoPointers(int numbers[], int target){
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int curSum = numbers[l] + numbers[r];
            if(curSum > target){
                r--;
            } else if(curSum < target){
                l++;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        return new int[0];
    }

    public int[] twoSumHashMap(int numbers[], int target){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int tmp = target - numbers[i];
            if(mp.containsKey(tmp)){
                return new int[] {mp.get(tmp), i+1};
            }
            mp.put(numbers[i], i+1);
        }
        return new int[0];
    }


    public int[] twoSumBinarySearch(int numbers[], int target){
        for(int i = 0; i < numbers.length; i++){
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];
            while (l <= r) {
                int mid = l + (r - l)/2;
                if(numbers[mid] == tmp){
                    return new int[] {1 + 1, mid + 1};
                } else if(numbers[mid] < tmp){
                    l = mid + 1;
                } else {
                    r = mid -1;
                }
            }

        }
        return new int[0];
    }

    public int[] twoSum(int []numbers, int target){
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i + 1, j+ 1};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] result = ts.twoSum(numbers, target);
        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
        int[] resultBinarySearch = ts.twoSumBinarySearch(numbers, target);
        if (resultBinarySearch.length > 0) {
            System.out.println("Indices using binary search: " + resultBinarySearch[0] + ", " + resultBinarySearch[1]);
        } else {
            System.out.println("No two sum solution found using binary search.");
        }
        int[] resultHashMap = ts.twoSumHashMap(numbers, target);
        if (resultHashMap.length > 0) {
            System.out.println("Indices using hash map: " + resultHashMap[0] + ", " + resultHashMap[1]);
        } else {
            System.out.println("No two sum solution found using hash map.");
        }
        int[] resultTwoPointers = ts.twoSumTwoPointers(numbers, target);
        if (resultTwoPointers.length > 0) {
            System.out.println("Indices using two pointers: " + resultTwoPointers[0] + ", " + resultTwoPointers[1]);
        } else {
            System.out.println("No two sum solution found using two pointers.");
        }
    }
}
