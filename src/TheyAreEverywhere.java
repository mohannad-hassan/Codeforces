import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 7/22/16.
 */
public class TheyAreEverywhere {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        TheyAreEverywhereFrequencyArr [] frequencyArrs = new TheyAreEverywhereFrequencyArr[n + 1];

        frequencyArrs[0] = new TheyAreEverywhereFrequencyArr();

        int max = 0;
        int maxI = 0;

        for (int i = 0; i < n; i++) {
            frequencyArrs[i + 1] = (TheyAreEverywhereFrequencyArr) frequencyArrs[i].clone();
            frequencyArrs[i + 1].increaseIndex(str.charAt(i));

            if (frequencyArrs[i + 1].unique > max) {
                max = frequencyArrs[i + 1].unique;
                maxI = i;
            }
        }

        int allChars = max;

        int answer = -1;
        if (allChars == 1)
            answer = 0;
        for (int range = 1; range <= maxI && answer == -1; range++) {
            for (int i = 0; i + range < n && answer == -1; i++) {
                int cnt = frequencyArrs[i + range + 1].minus(frequencyArrs[i]);

                if (cnt == allChars) {
                    answer = range;
                }
            }
        }

        System.out.println(answer + 1);
    }
}

class TheyAreEverywhereFrequencyArr {
    int [] array = new int[('z' - 'a' + 1) * 2];

    int unique = 0;

    @Override
    protected Object clone() {
        TheyAreEverywhereFrequencyArr copy = new TheyAreEverywhereFrequencyArr();

        for (int i = 0; i < array.length; i++) {
            copy.array[i] = this.array[i];
        }

        copy.unique = this.unique;

        return copy;
    }

    public void increaseIndex(char c) {
        int index = 0;
        if (c >= 'A' && c <= 'Z') {
            index = c - 'A';
        }
        else if ((c >= 'a') && (c <= 'z')) {
            index = c - 'a' + 'Z' - 'A' + 1;
        }

        array[index]++;

        if (array[index] == 1) {
            unique++;
        }
    }

    public int minus(TheyAreEverywhereFrequencyArr other) {
        int cnt = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > other.array[i])
                cnt++;
        }
        return cnt;
    }
}