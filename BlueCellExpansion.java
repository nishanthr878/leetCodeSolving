import java.util.HashSet;
import java.util.Set;

public class BlueCellExpansion {
    public static int countBlueCells(int n) {
        Set<String> blueCells = new HashSet<>();
        blueCells.add("0, 0");

        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};

        for(int minute =1; minute < n; minute++) {
            Set<String> newBlueCells = new HashSet<>(blueCells);

            for (String cell : blueCells) {
                String parts[] = cell.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                for(int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    newBlueCells.add(newX + "," + newY);
                }
            }
            blueCells = newBlueCells;
        }
        return blueCells.size();
    }
    public static void main(String args[]) {
        int n = 2;
        System.out.println(countBlueCells(n));
        int n1 = 4;
        System.out.println(countBlueCells(n1));
    }
}
