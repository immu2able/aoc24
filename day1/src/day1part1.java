

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day1part1 {


    private static List<Integer> left = new ArrayList<>();
    private static List<Integer> right = new ArrayList<>(); 

    public static void main(String[] args) {
        String filePath = "day1\\data\\input.txt";
        openFile(filePath);
        Long result = process();
        System.out.println(result);
    }

    private static Long  process() {
        Collections.sort(left);
        Collections.sort(right);
        Long result = 0l;
        for (int i = 0; i < left.size(); i++) {
            int diff =  left.get(i) - right.get(i);
            result += Math.abs(diff);
        }
        return result;
    }

    private static void openFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("   |\\n|\\r");

            while (myReader.hasNext()) {
                String l = myReader.next();
                String r = myReader.next();
                if (myReader.hasNext())
                    myReader.next(); // goto next line

                left.add(Integer.parseInt(l));
                right.add(Integer.parseInt(r));
        
            }

            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}