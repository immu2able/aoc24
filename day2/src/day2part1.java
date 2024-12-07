

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day2part1 {


    private static List<List<Integer>> reports = new ArrayList<>();
    

    public static void main(String[] args) {
        String filePath = "day2\\data\\input.txt";
        openFile(filePath);
        Long result = process();
        System.out.println(result);
    }

    private static Long  process() {
        Long result = 0l;
        //System.out.println(reports);

        // For each report list, check the direction by comparing the first 2 elements
        // if positive difference set flag descending to true
        // else if negative difference set flag descending to false
        // else if both numbers are same exit

        // then check the abs diff between the two consequtive levels should be between 1 - 3

        for (List<Integer> report : reports) {
            int first = report.get(0);
            int second = report.get(1);

            int diff = first-second;
            boolean descending = false;
            if (diff > 0) {
                descending = true;
            } 

            for (int i = 0; i < report.size()-1; i++) {
                diff = report.get(i) - report.get(i+ 1);
                int absDiff = Math.abs(diff);
                if ((diff == 0) 
                    || (diff < 0 && descending) 
                    || (diff > 0 && !descending)
                    || (absDiff > 3))  {
                        System.out.println("skipping report: " + report);
                        break;
                }
                if (i == report.size()-2) {
                    result++;
                }
            }
        }

        return result;
    }

    private static void openFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\\n|\\r");

            while (myReader.hasNext()) {
                String report = myReader.next();
                StringTokenizer st = new StringTokenizer(report, " ");
                List<Integer> repList = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    repList.add(Integer.parseInt(st.nextToken()));
                }
                reports.add(repList);

                if (myReader.hasNext())
                    myReader.next(); // goto next line

                
        
            }

            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}