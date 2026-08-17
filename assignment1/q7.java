package assignment1;

import java.util.Scanner;

class q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int n = sc.nextInt();

        int count = 0;

        while(n != 0) {
            n = n / 10;
            count++;
        }

        System.out.println("Number of digits = " + count);

        sc.close();
    }
}