

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        return rec(s, t, 0, 0);
    }

    private boolean rec(String s, String t, int i , int j) {
        if(i == s.length()) return true;
        if(j == t.length()) return false;

        if(s.charAt(i) == t.charAt(j)) {
            return rec(s, t, i+1, j+1);
        }
        return rec(s, t, i, j+1);
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        System.out.println(obj.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(obj.isSubsequence("axc", "ahbgdc")); // false
    }
}
