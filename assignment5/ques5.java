import java.util.*;

class Utility {
    static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class ques5 {
    public static void main(String[] args) {
        System.out.println(Utility.isEqual("Hello", "Hello"));
        System.out.println(Utility.isEqual(10, 20));

        System.out.println(Utility.getDefault(Optional.of("Java"), "Python"));
        System.out.println(Utility.getDefault(Optional.empty(), "Python"));

        System.out.println(Utility.max(10, 20));
        System.out.println(Utility.max("Apple", "Banana"));

        String s = null;
        Integer n = 100;

        System.out.println(Utility.isNull(s));
        System.out.println(Utility.isNull(n));
    }
}