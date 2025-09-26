public class ReplaceElements {
    public int[] replaceElementSuffixMax(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];
        int rightMax = -1;
        for(int i = n -1; i >= 0;i--) {
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }


    public int[] replaceElements(int arr[]) {
        int n = arr.length;
        int ans[] = new int [n];
        for(int i = 0; i < n-1; i++) {
            int rightMax = -1;
            for(int j = i + 1; j< n; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            ans[i] = rightMax;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReplaceElements obj = new ReplaceElements();
        int arr[] = {17,18,5,4,6,1};
        int result[] = obj.replaceElements(arr);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
