import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 11/8/15.
 */
public class VitalyAndNight {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < m; j += 1) {
                if (input[j * 2].charAt(0) == '1' || input[j * 2 + 1].charAt(0) == '1')
                    answer++;
            }
        }

        System.out.println(answer);
    }

}
