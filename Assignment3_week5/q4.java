

import java.util.Scanner;

class InvalidMarksException extends Exception {
    InvalidMarksException(String message) {
        super(message);
    }
}

public class q4 {

    public static void main(String[] args) {

        try {

            int eng, sci, maths;

            System.out.println("Enter three marks (0-100) only");

            Scanner sc = new Scanner(System.in);

            eng = sc.nextInt();
            sci = sc.nextInt();
            maths = sc.nextInt();

            if (eng < 0 || sci < 0 || maths < 0 || eng > 100 || sci > 100 || maths > 100) {

                throw new InvalidMarksException("Marks entered are invalid");

            } else {

                int total = eng + sci + maths;
                double per = (total / 300.0) * 100;
                String grade;

                if (per >= 90)
                    grade = "A";
                else if (per >= 80)
                    grade = "B";
                else if (per >= 70)
                    grade = "C";
                else if (per >= 60)
                    grade = "D";
                else
                    grade = "F";

                System.out.println("Total = " + total);
                System.out.println("Percentage = " + per);
                System.out.println("Grade = " + grade);
            }

        } catch (InvalidMarksException e) {

            System.out.println(e.getMessage());

        }
    }
}
