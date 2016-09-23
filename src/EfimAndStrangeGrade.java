import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/23/16.
 */
public class EfimAndStrangeGrade {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int t = Integer.parseInt(input[1]);

        String number = br.readLine();

        int dotIndex = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '.') {
                dotIndex = i;
            }
        }

        int firstIndex = -1;

        int [] digits = new int [number.length() - dotIndex - 1];
        for (int i = 0; i < digits.length; i++) {
            if (firstIndex == -1) {
                digits[i] = number.charAt(i + 1 + dotIndex) - '0';
                if (digits[i] > 4) {
                    firstIndex = i;
                }
            }
            else {
                digits[i] = 0;
            }
        }

        if (firstIndex == -1) {
            System.out.println(number);
        }
        else {
            int opIndex = firstIndex;
            boolean carry = false;
            while (opIndex >= 0 && t > 0) {
                if (digits[opIndex] > 4) {
                    round(digits, opIndex);
                    if (opIndex == 0) {
                        carry = true;
                    }
                    opIndex--;
                    t--;
                }
                else {
                    break;
                }
            }

            StringBuilder strBuilder = new StringBuilder();

            char [] integer = number.substring(0, dotIndex).toCharArray();
            if (carry) {
                int index = integer.length - 1;
                for (; index >= 0; index--) {
                    if (integer[index] == '9') {
                        integer[index] = '0';
                    }
                    else {
                        integer[index]++;
                        break;
                    }
                }
                carry = integer[0] == '0';
            }

            if (carry) {
                strBuilder.append('1');
            }
            strBuilder.append(integer);

            if (!(opIndex < 0 && digits[0] == 0)) {
                strBuilder.append('.');

                for (int i = 0; i <= opIndex; i++) {
                    strBuilder.append(digits[i]);
                }
                if (digits[opIndex + 1] != 0) {
                    strBuilder.append(digits[opIndex + 1]);
                }
            }
            System.out.println(strBuilder);
        }
    }

    static void round(int [] digits, int index) {
        digits[index] = 0;
        if (index > 0) {
            digits[index - 1]++;
        }
    }
}
