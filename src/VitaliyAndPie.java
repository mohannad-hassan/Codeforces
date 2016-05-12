import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class VitaliyAndPie {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		String s = br.readLine();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		int answer = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c += 'a' - 'A';
			}
			Integer count = map.get(c);
			if (i % 2 == 0) {
				if (count == null) {
					count = 0;
				}
				count ++;
			}
			else {
				if (count == null || count == 0) {
					answer ++;
				}
				else {
					count--;
				}
			}
			map.put(c, count);
		}
		
		System.out.println(answer);
	}

}
