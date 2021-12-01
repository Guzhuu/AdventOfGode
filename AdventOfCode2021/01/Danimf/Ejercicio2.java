import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/01/Danimf/input.txt")));
            String[] lines = new String[3];
            int lastDepth = Integer.MIN_VALUE;
            int depthGrows = 0;
            int currentLine = 3;
            //Leemos las 3 primeras líneas
            for (int i = 0; i < 3; i++) {
                lines[i] = fileReader.readLine();
            }

            int previousSum = Integer.parseInt(lines[0]) + Integer.parseInt(lines[1]) + Integer.parseInt(lines[2]);
            int currentSum;
            while ((lines[currentLine % 3] = fileReader.readLine()) != null){
                currentSum = Integer.parseInt(lines[0]) + Integer.parseInt(lines[1]) + Integer.parseInt(lines[2]);
                if(previousSum < currentSum){
                    depthGrows++;
                }
                previousSum = currentSum;
                currentLine++;
            }
            System.out.println(depthGrows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
