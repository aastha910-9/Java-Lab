
import java.io.*;
import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            FileOutputStream fout = new FileOutputStream("binary.dat");
            fout.write("Student Record Binary File".getBytes());
            fout.close();

            FileInputStream fin = new FileInputStream("binary.dat");
            FileOutputStream copy = new FileOutputStream("copy.dat");

            int data;
            while ((data = fin.read()) != -1) {
                copy.write(data);
            }

            fin.close();
            copy.close();

            System.out.println("Binary file copied successfully.");

            FileWriter fw = new FileWriter("students.txt", true);

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Student Marks: ");
            double marks = sc.nextDouble();

            fw.write("Student ID: " + id + "\n");
            fw.write("Student Name: " + name + "\n");
            fw.write("Student Course: " + course + "\n");
            fw.write("Student Marks: " + marks + "\n");
            fw.write("-------------------------\n");

            fw.close();

            System.out.println("\nStudent details saved successfully.");

            FileReader fr = new FileReader("students.txt");
            BufferedReader br = new BufferedReader(fr);

            System.out.println("\nStudent Records:");

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
