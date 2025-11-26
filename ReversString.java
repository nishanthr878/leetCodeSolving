import java.util.ArrayList;
import java.util.List;

/**
 * ReversString
 * Target interview question
 *
 * Given a string, reverse it without using inbuilt function
 * Time complexity : O(n)
 * Space complexity : O(n)
 */


public  class ReversString {
    public static void reversString(String s) {
        int n = s.length();
        List<Character> result = new ArrayList();
        int j = 0;
        s.toCharArray();
//        System.out.println(s.toCharArray());
        for(int i = n-1 ; i >= 0; i--) {
//            System.out.println(i);
//            System.out.println(s.charAt(i));
            result.add(s.charAt(i));

        }
        for( char p : result) {
            System.out.print(p);
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        reversString(s);
    }
}
