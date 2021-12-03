import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day03Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/03/Danimf/input.txt")));
        String[] lines = fileReader.lines().toArray(String[]::new);
        int lineLength = lines[0].length();
        int[] ones = new int[lineLength];
        int[] zeros = new int[lineLength];

        for(String line : lines){
            char[] numbers = line.toCharArray();
            for(int i = 0; i < numbers.length;i++){
                if(numbers[i] == '0'){
                    zeros[i]++;
                }else if(numbers[i] == '1'){
                    ones[i]++;
                }
            }
        }

        String gamma = "";
        String epsilon = "";
        for(int i = 0; i < lineLength; i++){
            if(ones[i] > zeros[i]){
                gamma += "1";
                epsilon += "0";
            } else{
                gamma += "0";
                epsilon += "1";
            }
        }

        System.out.println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }

}
