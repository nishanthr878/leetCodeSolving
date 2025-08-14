import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    public static String encode(List<String> strs){
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        System.out.println("res = " + res);
        List<Integer> sizes = new ArrayList<>();
        System.out.println("sizes = " + sizes);
        for(String str : strs) {
            sizes.add(str.length());
        }
        System.out.println("sizes after adding lengths = " + sizes);
        for(int size:sizes) {
            res.append(size).append(',');
        }
        System.out.println("res after adding sizes = " + res);
        res.append('#');
        for(String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static List<String>  decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while(str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for(int sz : sizes) {
            res.add(str.substring(i, i+ sz));
            i += sz;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("hello");
        strs.add("world");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
