public class VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int N = words.length;

        int[] ans = new int[queries.length];
        int[] prefixSums = new int[N];


        for(int i = 0; i < N; i++) {
            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            int currentCount = (isVowel(first) && isVowel(last) ? 1: 0);

            if( i == 0) {
                prefixSums[i] = currentCount;
            } else {
                prefixSums[i] = prefixSums[i - 1] + currentCount;
            }
        }



        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0) {
                ans[i] = prefixSums[right];
            } else {
                ans[i] = prefixSums[right] - prefixSums[left - 1];
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        String VOWELS = "aeiou";
        return VOWELS.indexOf(c) != -1;
    }

    public static void main(String[] args) {
        VowelStrings vs = new VowelStrings();
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        int[] result = vs.vowelStrings(words, queries);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
