import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/13/16.
 */
public class MeetingOfOldFriends {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long l1 = Long.parseLong(input[0]);
        long r1 = Long.parseLong(input[1]);
        long l2 = Long.parseLong(input[2]);
        long r2 = Long.parseLong(input[3]);
        long k  = Long.parseLong(input[4]);

        long l;
        long r;

        if (l1 <= l2) {
            l = l2;
        }
        else if (l1 <= r2) {
            l = l1;
        }
        else {
            l = -1;
        }

        if (r1 <= r2) {
            r = r1;
        }
        else {
            r = r2;
        }

        if (l > r || l == -1) {
            System.out.println(0);
        }
        else {
            long length = r - l + 1;
            if (k >= l && k <= r) {
                length--;
            }
            System.out.println(length);
        }
    }
}
