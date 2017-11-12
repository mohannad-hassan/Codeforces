import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by MohannadHassanPersonal on 11/12/17.
 */
public class ACM {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int [] scores = new int[input.length];

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
            sum += scores[i];
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = i + 1; j < scores.length; j++) {
                for (int k = j + 1; k < scores.length; k++) {
                    int score = scores[i] + scores[j] + scores[k];
                    if (score == sum - score) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }

        System.out.println("NO");
    }

}
