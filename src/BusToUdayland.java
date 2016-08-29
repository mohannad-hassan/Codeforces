import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/29/16.
 */
public class BusToUdayland {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder strBuilder = new StringBuilder();

        boolean gotSolution = false;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String [] pairs = s.split("\\|");

            if (!gotSolution) {
                if (pairs[0].equals("OO")) {
                    strBuilder.append("++|" + pairs[1]);
                    gotSolution = true;
                } else if (pairs[1].equals("OO")) {
                    strBuilder.append(pairs[0] + "|++");
                    gotSolution = true;
                }
                else {
                    strBuilder.append(s);
                }
            }
            else {
                strBuilder.append(s);
            }

            if (i < n - 1) {
                strBuilder.append("\n");
            }
        }

        if (gotSolution) {
            System.out.println("YES");
            System.out.println(strBuilder);
        }
        else {
            System.out.println("NO");
        }
    }
}
