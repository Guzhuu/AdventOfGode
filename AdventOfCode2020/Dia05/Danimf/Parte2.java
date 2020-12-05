import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Parte2 {
    public static void main(String[] args) throws Exception {
        FileReader file = new FileReader(new File("src/input.txt"));
        BufferedReader bufer = new BufferedReader(file);

        String asiento, fila, columna;
        int currentID;
        int filaMax, filaMin, colMax, colMin;
        ArrayList<Integer> asientos = new ArrayList<>();

        while ((asiento = bufer.readLine()) != null) {
            filaMax = 127;
            filaMin = 0;
            colMin = 0;
            colMax = 7;

            fila = asiento.substring(0, asiento.length() - 3);
            columna = asiento.substring(asiento.length() - 3);

            for (char s : fila.toCharArray()) {
                switch (s) {
                    case 'F':
                        filaMax = Math.floorDiv(filaMax + filaMin, 2);
                        break;
                    case 'B':
                        filaMin = Math.floorDiv(filaMax + filaMin, 2);
                        break;
                }
            }

            for (char s : columna.toCharArray()) {
                switch (s) {
                    case 'R':
                        colMin = Math.floorDiv(colMax + colMin, 2);
                        break;
                    case 'L':
                        colMax = Math.floorDiv(colMax + colMin, 2);
                        break;
                }
            }
            currentID = filaMax * 8 + colMax;
            asientos.add(currentID);
        }
        Collections.sort(asientos);
        for(int i = 1; i < asientos.size() - 1; i++){
            if((asientos.get(i)+1) != asientos.get(i+1)){
                System.out.println("Asiento: "+ (asientos.get(i) + 1));
                return;
            }
        }
    }
}