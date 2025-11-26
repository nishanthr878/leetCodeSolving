import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            int plusIndex = local.indexOf('+');
            if(plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");
            String normalizedEmail = local + "@" + domain;
            uniqueEmails.add(normalizedEmail);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        NumUniqueEmails solution = new NumUniqueEmails();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
        System.out.println(solution.numUniqueEmails(emails)); // Output: 2
    }
}
