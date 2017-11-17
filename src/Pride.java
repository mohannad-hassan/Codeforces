import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 11/17/17.
 */
public class Pride {


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] numbers = new int[count];

        int equalsOne = 0;

        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(input[i]);

            equalsOne += numbers[i] == 1 ? 1 : 0;
        }

        if (equalsOne != 0) {
            System.out.println(count - equalsOne);
        }
        else {
            int [] currentLevel = numbers;
            int [] nextLevel;
            int levelsProcessed = 0;

            boolean hasOne = false;

            while (!hasOne && currentLevel.length > 1) {
                nextLevel = new int[currentLevel.length - 1];

                for (int i = 0; i < nextLevel.length && !hasOne; i++) {
                    nextLevel[i] = gcd(currentLevel[i], currentLevel[i + 1]);
                    hasOne |= nextLevel[i] == 1;
                }

                levelsProcessed += 1;
                currentLevel = nextLevel;
            }

            if (hasOne) {
                System.out.println(levelsProcessed + count - 1);
            }
            else {
                System.out.println("-1");
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b > a) return gcd(b, a);

        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
