package assignment1;
import java.util.Scanner;
class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        String s = sc.next();
        int start = 0;
        int end = s.length() - 1;
        boolean palindrome = true;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                palindrome = false;
                break;
            }
            start++;
            end--;
        }
        if(palindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
        sc.close();
    }
}