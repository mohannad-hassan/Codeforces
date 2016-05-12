import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 5/11/16.
 */
public class RecyclingBottles {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        RecyclingBottlesCoord adil = new RecyclingBottlesCoord(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        RecyclingBottlesCoord bera = new RecyclingBottlesCoord(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        RecyclingBottlesCoord recBin = new RecyclingBottlesCoord(Integer.parseInt(input[4]), Integer.parseInt(input[5]));

        int n = Integer.parseInt(br.readLine());

        RecyclingBottlesCoord [] bottles = new RecyclingBottlesCoord[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            bottles[i] = new RecyclingBottlesCoord(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        double [] distances = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            double temp = recBin.distanceTo(bottles[i]);
            total += temp;
            distances[i]= temp;
        }


        double adilMin1 = Double.MAX_VALUE;
        double adilMin2 = Double.MAX_VALUE;
        double beraMin1 = Double.MAX_VALUE;
        double beraMin2 = Double.MAX_VALUE;

        int adilInd1 = -1;
        int adilInd2 = -1;
        int beraInd1 = -1;
        int beraInd2 = -1;

        for (int i = 0; i < n; i++) {
            double aTemp = adil.distanceTo(bottles[i]);
            double bTemp = bera.distanceTo(bottles[i]);

            if (aTemp < adilMin1) {
                adilMin2 = adilMin1;
                adilMin1 = aTemp;
                adilInd2 = adilInd1;
                adilInd1 = i;
            }
            else if (aTemp < adilMin2) {
                adilMin2 = aTemp;
                adilInd2 = i;
            }

            if (bTemp < beraMin1) {
                beraMin2 = beraMin1;
                beraMin1 = bTemp;
                beraInd2 = beraInd1;
                beraInd1 = i;
            }
            else if (aTemp < beraMin2) {
                beraMin2 = bTemp;
                beraInd2 = i;
            }
        }


        if (adilInd1 == beraInd1) {
            if (adilMin1 + beraMin2 < adilMin2 + beraMin1) {
                set.add(adilInd1);
                set.add(beraInd2);
                total = adilMin1 + beraMin2;
            }
            else  {
                set.add(adilInd2);
                set.add(beraInd1);
                total = adilMin2 + beraMin1;
            }
        }
        else {
            set.add(adilInd1);
            set.add(beraInd1);
            total = adilMin1 + beraMin1;
        }

        for (int i = 0; i < n; i++) {
            double temp = recBin.distanceTo(bottles[i]);
            total += temp;
            if (!set.contains(i)) {
                distances[i]= temp;
            }
        }

        java.util.Arrays.sort(distances);

        for (int i = 0; i < n; i++) {
            total += distances[i];
        }

        System.out.println(total);
    }
}

class RecyclingBottlesCoord {
    int x, y;

    public RecyclingBottlesCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(RecyclingBottlesCoord other) {
        int dx = x - other.x;
        int dy = y - other.y;

        return Math.sqrt(dx * dx + dy * dy);
    }
}