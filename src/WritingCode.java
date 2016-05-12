import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class WritingCode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String []input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int b = Integer.parseInt(input[2]);
		int mod = Integer.parseInt(input[3]);
		
		input = br.readLine().split(" ");
		int [] bi = new int[n];
		for (int i = 0; i < n; i++) {
			bi[i] = Integer.parseInt(input[i]);
		}
		
		HashMap<Integer, Integer> map0 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map0.put(0, 1);
		while(m-- > 0) {
			for (int i = 0; i < n; i++) {
				Iterator<Entry<Integer, Integer>> ite = map0.entrySet().iterator();
				while(ite.hasNext()) {
					
				}
			}
		}
	}

}
