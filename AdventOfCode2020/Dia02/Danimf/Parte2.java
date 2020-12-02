import java.io.BufferedReader;
import java.io.FileReader;

public class Parte2 {
    public static void main(String[] args) throws Exception{
        FileReader archivo = new FileReader("input.txt");
        BufferedReader lector = new BufferedReader(archivo);

        int max;
        int min;
        String linea;
        int validas = 0;
        char letra;
        String split[];
        String min_max[];
        int cuenta;

        while((linea = lector.readLine()) != null){
            cuenta = 0;

            split = linea.split(" ");
            min_max = split[0].split("-");

            min = Integer.parseInt(min_max[0]);
            max = Integer.parseInt(min_max[1]);
            letra = split[1].charAt(0);
            
            if( letra == split[2].charAt(min - 1) && letra != split[2].charAt(max - 1)){
                validas++;
            }
            else if(letra != split[2].charAt(min - 1) && letra == split[2].charAt(max - 1)){
                validas++;
            }
        }
        System.out.println(validas);
    }
}