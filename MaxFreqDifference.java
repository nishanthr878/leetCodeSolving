public class MaxFreqDifference {
    public static int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int freq[] = new int[5];

            for(int j = i; j < n; j ++) {
                freq[s.charAt(j) - '0']++;

                if (j - i + 1 >= k) {
                    for (int a = 0; a <5; a++) {
                        if (freq[a] % 2 == 1) {
                            for (int b = 0; b < 5; b++) {
                                if (freq[b] > 0 && freq[b] % 2 == 0) {
                                    int diff = freq[a] - freq[b];
                                    maxDiff = Math.max(maxDiff, diff);
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return  found ? maxDiff : -1;
    }

    public  static  void main(String args[]) {
        System.out.println(maxDifference("12233", 4));
        System.out.println(maxDifference("1122211", 3));
    }

}
