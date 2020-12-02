import java.io.BufferedReader;
import java.io.FileReader;

public class Parte1 {
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

            for(int i = 0; i < split[2].length(); i++){
                if( letra == split[2].charAt(i)){
                    cuenta++;
                }
            }

            if(cuenta >= min && cuenta <= max){
                validas++;
            }
        }
        System.out.println(validas);
    }
}
