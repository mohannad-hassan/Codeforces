import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AAndBAndChess {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int white = 0;
		int black = 0;
		
		for (int i = 0; i < 8; i++) {
			String row = br.readLine();
			
			for (int j = 0; j < row.length(); j++) {
				char c = row.charAt(j);
				
				switch (c) {
				case 'Q':
					white += 9;
					break;
					
				case 'q':
					black += 9;
					break;
					
				case 'R':
					white += 5;
					break;
					
				case 'r':
					black += 5;
					break;
					
				case 'B':
					white += 3;
					break;
					
				case 'b':
					black += 3;
					break;
					
				case 'N':
					white += 3;
					break;
					
				case 'n':
					black += 3;
					break;
					
				case 'P':
					white += 1;
					break;
				
				case 'p':
					black += 1;
					break;
				default:
					break;
				}
			}
		}
		
		if (white > black) {
			System.out.println("White");
		}
		else if (black > white) {
			System.out.println("Black");
		}
		else {
			System.out.println("Draw");
		}
	}

}
