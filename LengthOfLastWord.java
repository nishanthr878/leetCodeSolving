public class LengthOfLastWord {
    public int lengthOfLastWordBuiltIn(String s) {
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.lastIndexOf(" "));
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public int lengthOfLastWordItteration2(String s) {
        int n = s.length();
        int i = n - 1, len = 0;
        while(s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public int lengthOfLastWordItteration(String s) {
        int len = 0, i = 0;
        while (i < s.length()) {
            if(s.charAt(i) == ' '){
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (i == s.length()) {
                    return len;
                }
                len = 0;
            } else {
                len++;
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWordBuiltIn(s)); // Output: 5
    }
}
