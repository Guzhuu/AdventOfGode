import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day03Task2 {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/03/Danimf/input.txt")));
        String[] lines = fileReader.lines().toArray(String[]::new);

        int oxygen = Integer.parseInt(calculateOxygen(Arrays.asList(lines), 0), 2);
        int co2 = Integer.parseInt(calculateC02(Arrays.asList(lines), 0), 2);
        System.out.println(oxygen*co2);
    }

    private static String calculateOxygen(List<String> list, int position) {
        if (list.size() == 1) {
            return list.get(0);
        }

        List<String> oneListNumber = new ArrayList<>();
        List<String> zeroListNumber = new ArrayList<>();
        int mostCommon = 0;
        char number;

        for (String line : list) {
             number = line.charAt(position);
             if(number == '1'){
                 oneListNumber.add(line);
                 mostCommon++;
             } else{
                 zeroListNumber.add(line);
                 mostCommon--;
             }
        }

        if(mostCommon >= 0){
            return calculateOxygen(oneListNumber, position + 1);
        } else{
            return calculateOxygen(zeroListNumber, position + 1);
        }
    }
    private static String calculateC02(List<String> list, int position) {
        if (list.size() == 1) {
            return list.get(0);
        }

        List<String> oneListNumber = new ArrayList<>();
        List<String> zeroListNumber = new ArrayList<>();
        int mostCommon = 0;
        char number;

        for (String line : list) {
            number = line.charAt(position);
            if(number == '1'){
                oneListNumber.add(line);
                mostCommon++;
            } else{
                zeroListNumber.add(line);
                mostCommon--;
            }
        }

        if(mostCommon >= 0){
            return calculateC02(zeroListNumber, position + 1);
        } else{
            return calculateC02(oneListNumber, position + 1);
        }
    }

}
