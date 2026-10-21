public class ques1 {
    static <T extends Number> double sum(T[] arr) {
        double total = 0;

        for (T n : arr) {
            total += n.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] a = {10, 20, 30, 40};
        Float[] b = {1.5f, 2.5f, 3.5f};
        Double[] c = {10.5, 20.5, 30.5};

        System.out.println("Sum of Integers: " + sum(a));
        System.out.println("Sum of Floats: " + sum(b));
        System.out.println("Sum of Doubles: " + sum(c));
    }
}