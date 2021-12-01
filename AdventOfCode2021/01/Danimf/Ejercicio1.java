import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(new File("AdventOfCode2021/01/Danimf/input.txt")));
            String line;
            int lastDepth = Integer.MIN_VALUE;
            int depthGrows = 0;

            while((line=fileReader.readLine()) != null){
                if(lastDepth < Integer.parseInt(line)){
                    ++depthGrows;
                }
                lastDepth = Integer.parseInt(line);
            }

            System.out.println(depthGrows - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
