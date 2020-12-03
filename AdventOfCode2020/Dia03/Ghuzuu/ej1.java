import java.io.*;
import java.util.*;

public class ej1{
	public static void main(String[] args) {
		char arbol = '#';
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			String linea;
			List<String> input = new LinkedList<>();

			while((linea = br.readLine()) != null){
				input.add(linea);
			}

			int count = 0;
			int x = 0;
			int y = 0;
			do{
				String fila = input.get(y);
				if(fila.charAt(x % fila.length()) == arbol){
					count++;
				}
				
				x += 3;
				y++;
			}while(y < input.size());

			System.out.println("Arboles: " + count);
		}catch(Exception e){
			System.out.println("Oh no: " + e.toString());
		}
	}
}