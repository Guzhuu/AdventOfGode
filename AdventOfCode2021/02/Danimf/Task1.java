import java.io.*;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/02/Danimf/input.txt")));
        String line;
        int forward = 0;
        int depth = 0;

        String[] parts;
        while((line=fileReader.readLine()) != null){
            parts = line.split(" ");
            switch(parts[0]){
                case "forward":
                    forward += Integer.parseInt(parts[1]);
                    break;
                case "down":
                    depth += Integer.parseInt(parts[1]);
                    break;
                case "up":
                    depth -= Integer.parseInt(parts[1]);
                    break;
                default:
                    break;
            }
        }

        System.out.println(depth*forward);
    }
}
