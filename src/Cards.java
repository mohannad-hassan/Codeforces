import javax.smartcardio.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 * Created by MohannadHassanPersonal on 7/22/16.
 */
public class Cards {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        CardsPair [] numbers = new CardsPair[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = new CardsPair(i + 1, Integer.parseInt(input[i]));
        }

        java.util.Arrays.sort(numbers);

        for (int i = 0; i < n / 2; i++) {
            System.out.println(numbers[i].index + " " + numbers[n - i - 1].index);
        }
    }
}

class CardsPair implements Comparable<CardsPair> {
    int index = 0;
    int number = 0;

    public CardsPair(int index, int number) {
        this.index = index;
        this.number = number;
    }

    @Override
    public int compareTo(CardsPair o) {

        return o.number == this.number ? this.index - o.index : this.number - o.number;
    }
}