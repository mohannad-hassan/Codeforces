import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mohannadhassan on 8/10/15.
 */
public class PrimesOrPalindromes {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int p = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        LinkedList<Integer> primes = new LinkedList<>();
        int palindromes = 0;
        int i = 1;
        for (; true; i++) {
            boolean isPrime = i != 1;
            int root = (int)Math.ceil(Math.sqrt(i));
            for (Iterator<Integer> ite = primes.iterator(); isPrime && ite.hasNext(); ) {
                int temp = ite.next();
                if (temp > root)
                    break;;
                if (i % temp == 0)
                    isPrime = false;
            }

            boolean isPalindrome = testPalindrome(i + "");
            if (isPrime)
                primes.add(i);
            if (isPalindrome)
                palindromes++;

            if (primes.size() > (double) p * palindromes / q) {
                System.out.println(i - 1);
                System.exit(0);
            }
        }
    }

    private static boolean testPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
