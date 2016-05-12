import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by mohannadhassan on 3/3/16.
 */
public class Messenger {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedList<Integer> [] listsOfSequences = new LinkedList['z' - 'a' + 1];
        for (int i = 0; i < listsOfSequences.length; i++) {
            listsOfSequences[i] = new LinkedList<>();
        }

        String [] sequences = br.readLine().split(" ");
        MessengerPair [] tSeqs = new MessengerPair[sequences.length];
        for (int i = 0; i < sequences.length; i++) {
            String [] temp = sequences[i].split("-");
            int len = Integer.parseInt(temp[0]);
            char c = temp[1].charAt(0);
            tSeqs[i] = new MessengerPair(c, len);
        }

        tSeqs = combine(tSeqs);
        for (int i = 0; i < tSeqs.length; i++) {

            listsOfSequences[tSeqs[i].c - 'a'].add(i);
        }

        sequences = br.readLine().split(" ");
        MessengerPair [] sSeqs = new MessengerPair[sequences.length];
        for (int i = 0; i < sequences.length; i++) {
            String [] temp = sequences[i].split("-");
            int len = Integer.parseInt(temp[0]);
            char c = temp[1].charAt(0);

            sSeqs[i] = new MessengerPair(c, len);
        }

        sSeqs = combine(sSeqs);

        long count = 0;

        LinkedList<Integer> list = listsOfSequences[sSeqs[0].c - 'a'];

        for (Integer index : list) {
            if (sSeqs.length == 1) {
                MessengerPair sPair = sSeqs[0];
                MessengerPair tPair = tSeqs[index];
                count += tPair.len >= sPair.len ? tPair.len - sPair.len + 1 : 0;
            }
            else {
                if (visit(sSeqs, 0, tSeqs, index))
                    count++;
            }
        }
        System.out.println(count);
    }

    public static boolean visit(MessengerPair [] sSeqs, int sIndex, MessengerPair [] tSeqs, int tIndex) {
        while (sIndex < sSeqs.length && tIndex < tSeqs.length) {
            MessengerPair spair = sSeqs[sIndex];
            MessengerPair tpair = tSeqs[tIndex];
            if (spair.c != tpair.c) {
                return  false;
            }

            if ((sIndex > 0 && sIndex < sSeqs.length - 1)) {
                if (spair.len != tpair.len)
                    return false;
            }
            else if (tpair.len < spair.len) {
                return false;
            }
            sIndex++;
            tIndex++;
        }
        if (sIndex < sSeqs.length)
            return false;
        return true;
    }

    public static  MessengerPair [] combine(MessengerPair [] arr) {
        ArrayList<MessengerPair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j].c != arr[i].c)
                    break;
            }

            MessengerPair res = new MessengerPair(arr[i].c, 0);
            for (int k = i; k < j; k++) {
                res.len += arr[k].len;
            }
            i = j - 1;
            list.add(res);
        }
        return list.toArray(new MessengerPair[list.size()]);
    }
}

class MessengerPair {
    char c;
    int len;

    public MessengerPair(char c, int len) {
        this.c = c;
        this.len = len;
    }

    @Override
    public String toString() {
        return c + " - " + len;
    }
}