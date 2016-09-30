import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MohannadHassanPersonal on 9/30/16.
 */
public class Journey {

    static int time;
    static int best;
    static String result;

    static LinkedList<JourneyPair> [] adjacencyList;

    static int n;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        time = Integer.parseInt(input[2]);

        adjacencyList = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            adjacencyList[start].add(new JourneyPair(end, weight));
        }

        visit(1, 0, "", 0);
        System.out.println(best);
        System.out.println(result.trim());
        System.exit(0);
    }

    static void visit(int node, int t, String result, int count) {
        if (t > time) {
            return;
        }
        if (node == n) {
            count++;
            if (count > best) {
                best = count;
                result += " " + node;
                Journey.result = result;
            }

            return;
        }
        if (best == n) {
            return;
        }
        Iterator<JourneyPair> ite = adjacencyList[node].iterator();
        count++;
        result += " " + node;

        while (ite.hasNext()) {
            JourneyPair next = ite.next();
            visit(next.destincation, t + next.wieght, result, count);
        }
    }

    static List<JourneyAnswerPair> visit2(int node, int t, ) {

        return null;
    }
}

class JourneyPair {
    int destincation;
    int wieght;

    public JourneyPair(int destincation, int wieght) {
        this.destincation = destincation;
        this.wieght = wieght;
    }

    @Override
    public String toString() {
        return "To " + destincation + ": " + wieght;
    }
}

class JourneyAnswerPair {
    int time;
    int best;

    public JourneyAnswerPair(int time, int best) {
        this.time = time;
        this.best = best;
    }
}