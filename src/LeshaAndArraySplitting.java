import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MohannadHassanPersonal on 1/6/17.
 */
public class LeshaAndArraySplitting {


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int [] array = new int[input.length];
        boolean allZeroes = true;
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
            if (array[i] != 0) {
                allZeroes = false;
            }
            sum += array[i];
        }

        List<int []> solutions = new LinkedList<>();

        if (sum != 0) {
            solutions.add(array);
        }
        else if (!allZeroes) {
            for (int i = 0; i < n; i++) {
                if (array[i] != 0) {
                    int [] temp = {array[i]};
                    solutions.add(temp);
                }
                else if (solutions.size() == 0) {
                    int j;
                    for (j = i + 1; j < array.length && array[j] == 0; j++);
                    if (j == array.length) {
                        j--;
                    }
                    int [] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k] = array[k];
                    }
                    solutions.add(temp);
                    i = j;
                }
                else {
                    int [] temp = solutions.remove(solutions.size() - 1);
                    int [] newTemp = new int[temp.length + 1];
                    for (int j = 0; j < temp.length; j++) {
                        newTemp[j] = temp[j];
                    }
                    newTemp[newTemp.length - 1] = array[i];
                    solutions.add(newTemp);
                }
            }
        }

        if (solutions.size() == 0) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            System.out.println(solutions.size());
            int index = 1;
            for (Iterator<int []> ite = solutions.iterator(); ite.hasNext(); ) {
                int [] temp = ite.next();
                System.out.println(index + " " + (index + temp.length - 1));
                index += temp.length;
            }
        }
    }
}
