import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by MohannadHassanPersonal on 11/20/15.
 */
public class DayattheBeach {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");

        int [] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = numbers[i];

            Integer peek = stack.isEmpty() ? null : stack.peek();

            if (peek == null || num >= peek) {
                stack.push(num);
            }
            else {
                int max = peek;
                while (peek != null && num < peek) {
                    stack.pop();
                    peek = stack.isEmpty() ? null : stack.peek();
                }
                stack.push(max);
            }
        }

        System.out.println(stack.size());
    }
}
