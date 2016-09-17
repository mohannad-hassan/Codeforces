import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by MohannadHassanPersonal on 9/17/16.
 */
public class CompleteTheWord {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.length() < 26) {
            System.out.println(-1);
            return;
        }

        int [][] frequency = new int[s.length() + 1][27];
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'A';
            if (s.charAt(i) == '?') {
                charIndex = 26;
            }
            frequency[i + 1][charIndex] = 1;
            if (i > 0) {
                for (int j = 0; j <= 26; j++) {
                    frequency[i + 1][j] += frequency[i][j];
                }
            }
        }

        for (int i = 26; i <= s.length(); i++) {
            boolean success = true;
            ArrayList<Character> chars = new ArrayList<>();
            int j = i - 26;

            for (int k = 0; k < 26 && success; k++) {
                int diff = frequency[i][k] - frequency[j][k];
                if (diff == 0) {
                    chars.add((char)('A' + k));
                }
                else if (diff > 1) {
                    success = false;
                }
            }
            if (success) {
                if (chars.size() == frequency[i][26] - frequency[j][26]) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(s.substring(0, j));
                    for (int k = j; k < i; k++) {
                        if (s.charAt(k) == '?') {
                            builder.append(chars.remove(0));
                        }
                        else {
                            builder.append(s.charAt(k));
                        }
                    }
                    for (int k = i; k < s.length(); k++) {
                        if (s.charAt(k) == '?') {
                            builder.append('A');
                        }
                        else {
                            builder.append(s.charAt(k));
                        }
                    }
                    System.out.println(builder);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
