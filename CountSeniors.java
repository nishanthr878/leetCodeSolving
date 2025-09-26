public class CountSeniors {
    public int countSeniorsCharacterBasedExtraction(String [] details) {
        int res = 0;
        for(String d: details) {
            int ten = d.charAt(11) - '0';
            int one = d.charAt(12) - '0';
            int age = one + 10 * ten;
            if(age > 60) {
                res++;
            }
        }
        return res;

    }

    public int countSeniorsStringParsing(String[] details) {
        int res = 0;
        for(String d: details) {
            System.out.println(d.substring(11, 13));
            if(Integer.parseInt(d.substring(11, 13)) > 60) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSeniors solution = new CountSeniors();
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(solution.countSeniorsCharacterBasedExtraction(details)); // Output: 2
    }
}
