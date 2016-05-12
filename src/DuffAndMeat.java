import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DuffAndMeat {

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int needs [] = new int[n];
        int price [] = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            needs[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }

        long paid = 0;

        for (int i = 0; i < n; i++) {
            if (needs[i] != 0) {
                paid += needs[i] * price[i];
                for (int j = i + 1; j < n; j++) {
                    if(price[j] >= price[i]) {
                        paid += needs[j] * price[i];
                        needs[j] = 0;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        System.out.println(paid);
    }

}