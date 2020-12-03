import java.io.*;
import java.util.*;

public class ej2{
	public static void main(String[] args) {
		char arbol = '#';
		int[][] incs = new int[][]{new int[]{1, 1}, new int[]{3, 1}, new int[]{5, 1}, new int[]{7, 1}, new int[]{1, 2}};
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			String linea;
			List<String> input = new LinkedList<>();

			while((linea = br.readLine()) != null){
				input.add(linea);
			}

			int result = 1;
			int x = 0;
			int y = 0;
			int incX = 0;
			int incY = 0;
			int count = 0;
			for(int i = 0; i < incs.length; i++){
				count = 0;
				x = 0;
				y = 0;
				incX = incs[i][0];
				incY = incs[i][1];

				do{
					String fila = input.get(y);
					if(fila.charAt(x % fila.length()) == arbol){
						count++;
					}
					
					x += incX;
					y += incY;
				}while(y < input.size());
				result *= count;
			}

			System.out.println("Result: " + result);
		}catch(Exception e){
			System.out.println("Oh no: " + e.toString());
		}
	}
}