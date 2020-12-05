import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Parte1{
    public static void main(String[] args) throws Exception{
        FileReader file = new FileReader(new File("input.txt"));
        BufferedReader bufer = new BufferedReader(file);

        String asiento, fila, columna;
        int currentID, maxID = Integer.MIN_VALUE;
        int filaMax, filaMin, colMax, colMin;
        while( (asiento = bufer.readLine()) != null ){
            filaMax = 127;
            filaMin = 0;
            colMin = 0;
            colMax = 7;

            fila = asiento.substring(0, asiento.length() - 3);
            columna = asiento.substring(asiento.length() - 3);

            for( char s: fila.toCharArray()){
                switch(s){
                    case 'F':
                        filaMax = Math.floorDiv(filaMax + filaMin, 2);
                        break;
                    case 'B':
                        filaMin = Math.floorDiv(filaMax + filaMin, 2);
                        break;
                }
            }

            for( char s: columna.toCharArray()){
                switch(s){
                    case 'R':
                        colMin = Math.floorDiv(colMax+ colMin, 2);
                        break;
                    case 'L':
                        colMax = Math.floorDiv(colMax+ colMin, 2);
                        break;
                }
            }

            currentID= filaMax * 8 + colMax;
            if( currentID > maxID){
                maxID = currentID;
            }
            System.out.println("Asiento: "+asiento+" Fila: "+filaMax+" Columna: "+colMax);
        }
        System.out.println("Maximo: "+maxID);
    }
}