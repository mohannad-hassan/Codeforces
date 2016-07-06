import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 7/6/16.
 */
public class MikeAndCellphone {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int [] horizontal = {3,
                0, 0, 0,
                1, 1, 1,
                2, 2, 2};

        int [] vertical = {1,
                0, 1, 2,
                0, 1, 2,
                0, 1, 2};

        int [][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1}};

        int [] moveH = new int[s.length()];
        int [] moveV = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';

            moveH[i] = horizontal[c];
            moveV[i] = vertical[c];

            if (i > 0) {
                moveH[i - 1] = moveH[i] - moveH[i - 1];
                moveV[i - 1] = moveV[i] - moveV[i - 1];
            }
        }

        for (int i = 0; i < 10; i++) {
            int current = i;
            if (current == s.charAt(0) - '0') {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < s.length() - 1 && flag; j++) {
                int newH = horizontal[current] + moveH[j];
                int newZ = vertical[current] + moveV[j];
                if (!(newH >= 0 && newH < 4 && newZ >= 0 && newZ < 3)) {
                    flag = false;
                    break;
                }
                int next = matrix[horizontal[current] + moveH[j]][vertical[current] + moveV[j]];
                if (next == -1) {
                    flag = false;
                    break;
                }
                current = next;
            }
            if (flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}
