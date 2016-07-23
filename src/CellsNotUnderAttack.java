import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by MohannadHassanPersonal on 7/22/16.
 */
public class CellsNotUnderAttack {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder((int)n);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            rows.add(row);
            cols.add(col);

            long remaining = n * n - rows.size() * n - cols.size() * n + (long) rows.size() * cols.size();
            stringBuilder.append(remaining);
            if (i < m -1) {
                stringBuilder.append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
