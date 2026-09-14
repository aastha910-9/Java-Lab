

public class q1 {
    public static void main(String[] args) {

        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred");
        }

        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred");
        }

        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        }

        try {
            int n = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred");
        }
    }
}