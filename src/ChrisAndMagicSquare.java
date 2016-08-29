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

        boolean success = true;
        long sum = -1;
        long zeroSum = -1;

        long [][] matrix = new long[n][n];
        int zeroI = 0, zeroJ = 0;

        for (int i = 0; i < n; i++) {
            String input [] = br.readLine().split(" ");

            boolean hasZero = false;

            long tempSum = 0;

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    zeroI = i;
                    zeroJ = j;
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

        matrix[zeroI][zeroJ] = sum - zeroSum;

        for (int i = 0; i < n && success; i++) {
            long tempSum = 0;
            for (int j = 0; j < n; j++) {
                tempSum += matrix[j][i];
            }
            if (tempSum != sum) {
                success = false;
            }
        }

        long tempSum1 = 0, tempSum2 = 0;
        for (int i = 0; i < n && success; i++) {
            tempSum1 += matrix[i][i];
            tempSum2 += matrix[i][n - i - 1];
        }
        success = (tempSum1 == sum ) &&
                  (tempSum2 == sum );

        long answer = success ? sum - zeroSum : -1;

        System.out.println(n == 1 ? 1 : answer);
    }
}
