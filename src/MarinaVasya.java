import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 10/6/15.
 */
public class MarinaVasya {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        String s1 = br.readLine();
        String s2 = br.readLine();

        char [] ans = new char[n];

        if (t == 0) {
            ans = s1.equals(s2) ? s2.toCharArray() : null;
        }

        boolean [] isSimilar = new boolean[n];
        int similarCount = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                isSimilar[i] = true;
                similarCount++;
            }
        }

        if (similarCount < n - t){
            ans = null;
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!isSimilar[i]) {
                    ans[i] = getChar(s1.charAt(i), s2.charAt(i));
                    t--;
                }
            }
            for (int i = 0; i < n; i++) {
                if (isSimilar[i]) {
                    if (t > 0) {
                        ans[i] = getChar(s1.charAt(i), s2.charAt(i));
                        t--;
                    }
                    else  {
                        ans[i] = s1.charAt(i);
                    }
                }
            }
        }

        System.out.println(ans == null ? "-1" : new String(ans));
    }

    public static char getChar(char c1, char c2) {
        for (char temp = 'a'; temp <= 'z'; temp++) {
            if (temp != c1 && temp != c2)
                return temp;
        }
        return 'a';
    }
}
