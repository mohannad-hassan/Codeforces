import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/29/16.
 */
public class ChrisAndMagicSquare {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = -1;
        long zeroSum = -1;
        boolean success = true;

        int [][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input [] = br.readLine().split(" ");

            boolean hasZero = false;

            long tempSum = 0;

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
                if (matrix[i][j] == 0) {
                    hasZero = true;
                }
                tempSum += matrix[i][j];
            }

            if (success) {
                if (hasZero) {
                    zeroSum = tempSum;
                }
                else if (sum == -1) {
                    sum = tempSum;
                }
                else if (sum != tempSum){
                    success = false;
                }
            }
        }

        success = sum != -1 && zeroSum != -1 && zeroSum < sum;

        for (int i = 0; i < n && success; i++) {
            long tempSum = 0;
            for (int j = 0; j < n; j++) {
                tempSum += matrix[j][i];
            }
            if (tempSum != sum && tempSum != zeroSum) {
                success = false;
            }
        }

        long tempSum1 = 0, tempSum2 = 0;
        for (int i = 0; i < n && success; i++) {
            tempSum1 += matrix[i][i];
            tempSum2 += matrix[i][n - i - 1];
        }
        success = (tempSum1 == sum || tempSum1 == zeroSum) &&
                  (tempSum2 == sum || tempSum2 == zeroSum);

        long answer = success ? sum - zeroSum : -1;

        System.out.println(answer);
    }
}
