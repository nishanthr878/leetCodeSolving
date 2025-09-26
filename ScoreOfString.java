public class ScoreOfString {
    public int scoreOfString(String s) {
        int res = 0;
        for(int i = 0; i < s.length() -1; i++) {
            int k = s.charAt(i);
            int l = s.charAt(i + 1);
            int m = Math.abs(k - l);
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        ScoreOfString solution = new ScoreOfString();
        String s = "abc";
        int result = solution.scoreOfString(s);
        System.out.println("The score of the string \"" + s + "\" is: " + result);
    }
}
