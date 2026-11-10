
import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

public class ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("employee.dat"));

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details of Employee " + i);

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                Employee emp = new Employee(id, name, department, salary);
                oos.writeObject(emp);
            }

            oos.close();

            System.out.println("\nEmployee records saved successfully.");

            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("employee.dat"));

            System.out.println("\nEmployee Records Retrieved:");

            for (int i = 1; i <= n; i++) {
                Employee emp = (Employee) ois.readObject();
                emp.display();
            }

            ois.close();

        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
