import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by MohannadHassanPersonal on 7/22/16.
 */
public class TheyAreEverywhere {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        HashSet<Character> allCharsSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            allCharsSet.add(str.charAt(i));
        }

        int allChars = allCharsSet.size();

        int min = str.length();

        int low = 0, high = 0;
        TheyAreEverywhereFrequencyArr arr = new TheyAreEverywhereFrequencyArr();

        while (high < str.length()) {

            while (high < str.length() && arr.unique < allChars) {
                arr.increaseIndex(str.charAt(high));
                high++;
            }

            if (arr.unique < allChars) {
                break;
            }

            while (low <= high && arr.unique == allChars) {
                arr.descreaseIndex(str.charAt(low));
                low++;
            }
            int len = high - low + 1;

            if (len < min)
                min = len;
        }

        System.out.println(min);
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
        printCharacter(c, index);

        if (array[index] == 1) {
            unique++;
        }
    }

    private void printCharacter(char c, int index) {
//        System.out.println("Update [" + c + "] to " + array[index]);
    }

    public void descreaseIndex(char c) {
        int index = 0;
        if (c >= 'A' && c <= 'Z') {
            index = c - 'A';
        }
        else if ((c >= 'a') && (c <= 'z')) {
            index = c - 'a' + 'Z' - 'A' + 1;
        }

        array[index]--;
        printCharacter(c, index);

        if (array[index] == 0) {
            unique--;
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