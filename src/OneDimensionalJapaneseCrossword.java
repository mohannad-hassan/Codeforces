import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by MohannadHassanPersonal on 9/30/16.
 */
public class OneDimensionalJapaneseCrossword {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                int j;
                for (j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'W')
                        break;
                }
                list.add(j - i);
                i = j - 1;
            }
        }

        System.out.println(list.size());
        Iterator<Integer> ite = list.iterator();

        boolean start = true;
        while (ite.hasNext()) {
            if (start) {
                start = false;
            }
            else {
                System.out.print(" ");
            }
            System.out.print(ite.next());
        }
    }
}
