import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;

/**
 * Created by MohannadHassanPersonal on 6/11/16.
 */
public class Report {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int []array = new int[n];
        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        ArrayList<ReportPair> queries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            ReportPair query = new ReportPair(input[0].charAt(0) == '1',
                    Integer.parseInt(input[1]));

            int j;
            boolean ignore = false;
            for (j = queries.size() - 1; j >= 0; j--) {
                if (queries.get(j).asc != query.asc && queries.get(j).len > query.len)
                    break;
                else if (queries.get(j).asc == query.asc && queries.get(j).len >= query.len) {
                    ignore = true;
                    break;
                }
                queries.remove(j);
            }
            if (!ignore)
                queries.add(query);
        }

        ReportPair firstQuery = queries.get(0);
        int []workingArray = java.util.Arrays.copyOf(array, firstQuery.len);
        Arrays.sort(workingArray);
        if (!firstQuery.asc) {
            for (int i = 0; i < workingArray.length / 2; i++) {
                int temp = workingArray[i];
                workingArray[i] = workingArray[workingArray.length - i - 1];
                workingArray[workingArray.length - i - 1] = temp;
            }
        }

        boolean fromRight = true;

        int i;
        int min = 0;
        int max = workingArray.length - 1;
        int arrayI = max;

        for (i = 1; i < queries.size(); i++) {
            int len = queries.get(i - 1).len - queries.get(i).len;
            int j;
            int inc;
            if (!fromRight) {
                j = min;
                inc = 1;
            }
            else  {
                j = max;
                inc = -1;
            }
            while (len > 0) {
                array[arrayI--] = workingArray[j];
                len--;
                j += inc;
            }

            if (!fromRight) {
                min = j;
            }
            else  {
                max = j;
            }
            fromRight = !fromRight;
        }
        boolean asc = !(queries.get(queries.size() - 1).asc ^ firstQuery.asc);
        while (min <= max) {
            array[arrayI--] = workingArray[asc ? max-- : min++];
        }

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < array.length; j++) {
            if (j > 0)
                builder.append(' ');
            builder.append(array[j]);
        }
        System.out.println(builder.toString());
    }
}

class ReportPair {
    boolean asc;
    int len;

    public ReportPair(boolean asc, int len) {
        this.asc = asc;
        this.len = len;
    }
}