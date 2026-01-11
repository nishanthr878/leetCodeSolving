import java.util.Arrays;

public class DividePlayerIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        int teams = n / 2;

        long sum = 0;
        for(int s : skill) {
            sum += s;
        }

        if(sum % teams != 0) {
            return  - 1;
        }

        long target = sum / teams;

        Arrays.sort(skill);

        long chemistry = 0;
        int left = 0, right = n - 1;

        while(left < right) {
            if(skill[left] + skill[right] != target) {
                return -1;
            }

            chemistry += (long) skill[left] * skill[right];
            left++;
            right--;
        }
        return chemistry;
    }

    public static void main(String[] args) {
        DividePlayerIntoTeamsOfEqualSkill divider = new DividePlayerIntoTeamsOfEqualSkill();
        int[] skill = {3, 2, 5, 1, 3, 4};
        long result = divider.dividePlayers(skill);
        System.out.println(result); // Output: 22
    }
}
