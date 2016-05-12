import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class DuffInLove {

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long tempN = n;
        long root = (long)Math.sqrt(n);

        long answer = 1;

        LinkedList<Integer> primes = new LinkedList<Integer>();

        for (int i = 2; i <= tempN && i <= root; i++) {
            if (tempN % i != 0)
                continue;
            primes.add(i);
            answer *= i;
            while(tempN % i == 0) {
                tempN /= i;
            }
        }

        if (primes.isEmpty())
            answer = n;
        else
            answer *= tempN;

        System.out.println(answer);
    }

}