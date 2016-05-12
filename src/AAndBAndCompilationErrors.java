import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class AAndBAndCompilationErrors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		br.readLine();
		
		String [] input = br.readLine().split(" ");
		
		for (String string : input) {
			Integer i = Integer.parseInt(string);
			
			Integer count = map.get(i);
			
			int c = count != null ? count : 0;
			c ++;
			
			map.put(i, c);
		}
		
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		
		input = br.readLine().split(" ");
		
		reduce(map, input, map2);
		
		System.out.println(map.keySet().toArray() [0]);
		
		map = map2;
		
		map2 = new HashMap<Integer, Integer>();
		
		input = br.readLine().split(" ");
		
		reduce(map, input, map2);
		
		System.out.println(map.keySet().toArray() [0]);
	}

	private static void reduce(HashMap<Integer, Integer> map, String[] input,
			HashMap<Integer, Integer> map2) {
		for (String string : input) {
			Integer i = Integer.parseInt(string);
			
			Integer c1 = map.get(i);
			Integer c2 = map2.get(i);
			
			int count2 = c2 != null ? c2 : 0;
			
			c1 --;
			count2 ++;
			
			if (c1 == 0) {
				map.remove(i);
			}
			else {
				map.put(i, c1);
			}
			
			map2.put(i, count2);
		}
	}

}
