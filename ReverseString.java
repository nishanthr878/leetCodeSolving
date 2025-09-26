import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseString {
    public void reverseStringArray(char[] s) {
        char[] tmp = new char[s.length];
        for(int i = s.length -1, j = 0; i >=0; i--, j++) {
            tmp[j] = s[i];
        }
        for(int i = 0; i < s.length; i++) {
            s[i] = tmp[i];
        }
    }

    public void reverseStringRecursion(char[] s) {
        reverse(s, 0, s.length -1);
    }

    private void reverse(char[] s, int l, int r) {
        if( l  < r) {
            reverse(s, l +1, r -1);
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }


    public void reversStringStack(char[] s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s) {
            stack.push(c);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            s[i++] = stack.pop();
        }
    }

    public void reverseStringBuiltin(char[] s) {
        List<Character> list = new ArrayList<>();
        for(char c : s) {
            list.add(c);
        }
        Collections.reverse(list);
        for(int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }
    }

    public void reverseStringTwoPointer(char[] s) {
        int l = 0, r = s.length -1;
        while (l < r) {
            char temp = s[l];
            s[l]  = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = {'h','e','l','l','o'};
        rs.reverseStringArray(s);
        System.out.println(s);
    }
}
