public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome("Was it a car or a cat I saw?")); // true:
        System.out.println(ip.isPalindrome("tab a cat"));
        System.out.println(ip.isPalindromeTwoPointers("Was it a car or a cat I saw?")); // true
        System.out.println(ip.isPalindromeTwoPointers("tab a cat"));
    }

    public boolean isPalindromeTwoPointers(String s){
        int l = 0, r = s.length() - 1;
        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while( r > l && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s){
        StringBuilder newStr = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }
}
