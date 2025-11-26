import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tchar = t.charAt(i);

            if(sToTMapping.containsKey(sChar)) {
                if(sToTMapping.get(sChar) != tchar) {
                    return false;
                }
            } else {
                if(tToSMapping.containsKey(tchar)) {
                    if(tToSMapping.get(tchar) != sChar) {
                        return false;
                    }
                }
            }
            sToTMapping.put(sChar, tchar);
            tToSMapping.put(sChar,sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic iso = new IsIsomorphic();
        String s = "egg";
        String t = "add";
        System.out.println(iso.isIsomorphic(s, t)); // Output: true
    }
}
