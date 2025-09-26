import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(s1Count[i] == s2count[i]){
                matches++;
            }
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            if(matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2count[index]++;
            if(s1Count[index] == s2count[index]) {
                matches++;
            } else if(s1Count[index] + 1 == s2count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2count[index]--;
            if(s1Count[index] == s2count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;

    }


    public boolean checkInclusionHashTable(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();

        for(char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        int need = count1.size();
        for(int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int cur = 0;
            for(int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                if(count1.getOrDefault(c, 0) < count2.get(c)) {
                    break;
                }
                if(count1.getOrDefault(c, 0) == count2.get(c)) {
                    cur++;
                }
                if(cur == need) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] S1Arr = s1.toCharArray();
        Arrays.sort(S1Arr);
        String sortedS1 = new String(S1Arr);

        for(int i = 0; i < s2.length(); i++) {
            for(int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubstr = new String(subStrArr);

                if(sortedSubstr.equals(sortedS1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        System.out.println(ci.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(ci.checkInclusion("ab", "eidboaoo")); // false
        System.out.println(ci.checkInclusionHashTable("ab", "eidbaooo"));
        System.out.println(ci.checkInclusionSlidingWindow("ab", "eidbaooo"));
    }
}
