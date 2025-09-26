public class ValidPalindromell {
    public boolean validPalindomreTwoPointer(String s) {
        int l = 0, r = s.length() -1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(0, l) + s.substring(l + 1)) || isPalindrome(s.substring(0, r) + s.substring(r + 1));
            }
            l++;
            r--;
        }
        return true;
    }



    /**
     *
     * @param s
     * @return boolean
     */

    public boolean validPalindrome(String s) {
        if(isPalindrome(s)) {
            return true;
        }

        for(int i = 0; i < s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i + 1);
            if(isPalindrome(newS)) {
                return true;
            }
        }
        return false;
    }


    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() -1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main (String[] args) {
        ValidPalindromell string = new ValidPalindromell();
        String s = "abca";
        System.out.println(string.validPalindrome(s));
        System.out.println(string.validPalindomreTwoPointer(s));
    }
}
