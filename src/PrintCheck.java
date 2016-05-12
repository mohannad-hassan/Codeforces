import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 3/3/16.
 */
public class PrintCheck {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int ops = Integer.parseInt(input[2]);

        int [] rows = new int [r + 1];
        int [] cols = new int [c + 1];
        int [] operations = new int [ops + 1];

        for (int i = 0; i < ops; i++) {
            input = br.readLine().split(" ");

            int index = Integer.parseInt(input[1]);
            int color = Integer.parseInt(input[2]);
            operations[i + 1] = color;

            if (input[0].startsWith("1")) {
                rows[index] = i + 1;
            }
            else {
                cols[index] = i + 1;
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int temp;
                if (rows[i] > cols[j]) {
                    temp = operations[rows[i]];
                }
                else {
                    temp = operations[cols[j]];
                }
                if (j != 1) {
                    System.out.print(" ");
                }
                System.out.print(temp);
            }
            System.out.println();
        }
    }
}
