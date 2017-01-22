import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 1/22/17.
 */
public class PetrAndCalendar {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        int [] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int allDays = daysPerMonth[m - 1];

        int weeks = 1;

        allDays -= (7 - d + 1);

        weeks += allDays / 7;

        allDays %= 7;

        if (allDays != 0)
            weeks ++;

        System.out.println(weeks);
    }
}
