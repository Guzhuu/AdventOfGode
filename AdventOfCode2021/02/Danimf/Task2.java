import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/02/Danimf/input.txt")));
        String line;
        int forward = 0;
        int depth = 0;
        int aim = 0;

        String[] parts;
        while((line=fileReader.readLine()) != null){
            parts = line.split(" ");
            switch(parts[0]){
                case "forward":
                    forward += Integer.parseInt(parts[1]);
                    depth += Integer.parseInt(parts[1])*aim;
                    break;
                case "down":
                    aim += Integer.parseInt(parts[1]);
                    break;
                case "up":
                    aim -= Integer.parseInt(parts[1]);
                    break;
                default:
                    break;
            }
        }

        System.out.println(depth*forward);
    }
}
