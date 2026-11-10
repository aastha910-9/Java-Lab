
import java.io.*;
import java.util.Scanner;

public class ques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        try {
            System.out.print("Enter log file name: ");
            String fileName = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter("filtered_logs.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                totalEntries++;

                if (line.contains("ERROR")) {
                    errorCount++;
                    bw.write(line);
                    bw.newLine();
                } else if (line.contains("WARNING")) {
                    warningCount++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            System.out.println("\nLog Analysis Completed Successfully.");
            System.out.println("Total Log Entries: " + totalEntries);
            System.out.println("Total ERROR Entries: " + errorCount);
            System.out.println("Total WARNING Entries: " + warningCount);
            System.out.println("Filtered logs saved in filtered_logs.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Log file not found.");
        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

