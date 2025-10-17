public class SortArray {
    /**
     * Selection Sort
     * @param nums
     * @return nums sorted array
     * Algorithm:
     * 1. Iterate through the array from the first element to the second last element.
     * 2. For each element, assume it is the minimum and store its index.
     * 3. Iterate through the remaining unsorted elements to find the actual minimum element.
     * 4. If a smaller element is found, update the minimum index.
     * 5. After finding the minimum element in the unsorted portion, swap it with the first unsorted element.
     * 6. Repeat until the entire array is sorted.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     */
    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    /**
     * Insertion Sort
     * @param nums
     * @return nums sorted array
     *
     * Algorithm:
     * 1. Iterate through the array starting from the first element to the last element.
     * 2. For each element, store its value and initialize a pointer to the current index.
     * 3. Compare the stored value with the elements before it in the sorted portion of the array.
     * 4. Shift elements that are greater than the stored value one position to the right.
     * 5. Insert the stored value at its correct position in the sorted portion.
     * 6. Repeat until the entire array is sorted.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     */

    public int[] insertionSort(int nums[]) {
        for(int i = 0; i < nums.length-1; i++) {
            int value = nums[i];
            int j = i;
            while(j > 0 && nums[j-1] > value) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = value;
        }
        return nums;
    }


    /**
     *
     * @param nums
     * @return nums sorted array
     *
     * Algorithm:
     * 1. Iterate through the array from the last element to the first element.
     * 2. For each element, compare it with the next element.
     * 3. If the current element is greater than the next element, swap them.
     * 4. Repeat the process for the entire array until no swaps are needed.
     * 5. The array is sorted when a complete pass is made without any swaps.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] bubbleSort(int nums[]) {
        int n = nums.length;;
        for(int i = n -1; i >= 0; i--) {
            for(int j = 0; j <= i -1; j++) {
                if(nums[j]  > nums[j+1] ) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        SortArray sa = new SortArray();
        int[] nums = {3, 5, 8, 4, 1, 9, -2};
        int[] sortedNums = sa.selectionSort(nums);
        int[] sortedNums2 = sa.insertionSort(nums);
        int[] sortedNums3 = sa.bubbleSort(nums);
        System.out.println("Sorted array using Selection Sort:");
        for(int num : sortedNums) {
            System.out.print(num + " ");
        }
        System.out.println("\nSorted array using Insertion Sort:");
        for(int num : sortedNums2) {
            System.out.print(num + " ");
        }
        System.out.println("\nSorted array using Bubble Sort:");
        for(int num : sortedNums3) {
            System.out.print(num + " ");
        }
    }
}
