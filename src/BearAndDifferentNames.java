import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 3/18/17.
 */
public class BearAndDifferentNames {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int groups =  n - k + 1;

        boolean [] boolArr = new boolean[groups];

        input = br.readLine().split(" ");

        for (int i = 0; i < groups; i++) {
            boolArr[i] = input[i].equals("YES");
        }

        String [] solution = new String[n];

        for (int i = 0; i < groups; i++) {
            if (boolArr[i]) {
                for (int j = i; j < i + k; j++) {
                    solution[j] = getString(j);
                }
            }
        }

        for (int i = 0; i < groups; i++) {
            if (!boolArr[i]) {
                String temp = null;
                for (int j = i; j < i + k && temp == null; j++) {
                    temp = solution[j];
                }
                if (temp == null) {
                    temp = "Null";
                }
                for (int j = i; j < i + k && temp != null; j++) {
                    if (solution[j] == null || solution[j].equals("Null")) {
                        solution[j] = temp;
                    }
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            if (solution[i] == null) {
//                solution[i] = "null";
//            }
//        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0)
                builder.append(" ");
            builder.append(solution[i]);
        }
        System.out.println(builder.toString());
    }

    static String getString(int n) {
        String s = "";
        while (n > 0 ) {
            int temp = n % 26;
            s += (char)('a' + temp);
            n/=26;
        }
        return "S" + s;
    }
}
