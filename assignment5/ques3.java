import java.util.*;

class Result<T extends Number> {
    T marks;

    Result(T marks) {
        this.marks = Objects.requireNonNull(marks);
    }

    double getPercentage(double total) {
        return (marks.doubleValue() / total) * 100;
    }

    boolean isPassed(double threshold, double total) {
        return getPercentage(total) >= threshold;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class ques3 {
    public static void main(String[] args) {
        Result<Double> r = new Result<>(85.0);

        r.getMarks().ifPresent(m -> {
            System.out.println("Marks: " + m);
            System.out.println("Percentage: " + r.getPercentage(100));
            System.out.println("Passed: " + r.isPassed(40, 100));
        });
    }
}