import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by MohannadHassanPersonal on 11/12/17.
 */
public class PetyaAndCatacombs {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] roomsLog = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            roomsLog[i] = Integer.parseInt(input[i]);
        }

        HashMap<Integer, Integer> lastVistisPerRoom = new HashMap<>();

        int [] roomsPerMinute = new int [count + 1];
        roomsPerMinute[0] = 0;
        lastVistisPerRoom.put(0, 0);

        int max = 1;

        for (int day = 1; day <= count; day++) {
            int log = roomsLog[day - 1];
            int previousRoom = roomsPerMinute[log];

            Integer roomLastVisit = lastVistisPerRoom.get(previousRoom);
            if (roomLastVisit == null || roomLastVisit != log) {
                int newRoom = max;
                max++;

                roomsPerMinute[day] = newRoom;
                lastVistisPerRoom.put(newRoom, day);
            }
            else {
                roomsPerMinute[day] = previousRoom;
                lastVistisPerRoom.put(previousRoom, day);
            }
        }

        System.out.println(lastVistisPerRoom.size());
    }
}
