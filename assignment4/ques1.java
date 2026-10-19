import java.util.*;

class Course {
    String code;
    int capacity;
    HashSet<String> students;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;

    Course(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
        students = new HashSet<>();
        prerequisites = new ArrayList<>();
        waitlist = new LinkedList<>();
    }
}

public class ques1 {
    static HashMap<String, Course> courses = new HashMap<>();

    static void addCourse(String code, int capacity, ArrayList<String> pre) {
        Course c = new Course(code, capacity);
        c.prerequisites.addAll(pre);
        courses.put(code, c);
    }

    static boolean checkPrerequisites(String student, Course c) {
        for (String p : c.prerequisites) {
            Course pre = courses.get(p);
            if (pre == null || !pre.students.contains(student)) {
                return false;
            }
        }
        return true;
    }

    static void register(String student, String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        if (c.students.contains(student) || c.waitlist.contains(student)) {
            System.out.println("Already registered or waitlisted");
            return;
        }

        if (!checkPrerequisites(student, c)) {
            System.out.println("Prerequisites not completed");
            return;
        }

        if (c.students.size() < c.capacity) {
            c.students.add(student);
            System.out.println("Registration successful");
        } else {
            c.waitlist.addLast(student);
            System.out.println("Added to waitlist");
        }
    }

    static void drop(String student, String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        if (c.waitlist.remove(student)) {
            System.out.println("Removed from waitlist");
            return;
        }

        if (!c.students.remove(student)) {
            System.out.println("Student not registered");
            return;
        }

        System.out.println("Course dropped");

        while (!c.waitlist.isEmpty() && c.students.size() < c.capacity) {
            String next = c.waitlist.removeFirst();

            if (checkPrerequisites(next, c)) {
                c.students.add(next);
                System.out.println(next + " promoted from waitlist");
            } else {
                System.out.println(next + " skipped due to incomplete prerequisites");
            }
        }
    }

    static void display(String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Course: " + c.code);
        System.out.println("Enrolled Students: " + c.students);
        System.out.println("Prerequisites: " + c.prerequisites);
        System.out.println("Waitlist: " + c.waitlist);
    }

    public static void main(String[] args) {
        addCourse("CS101", 2, new ArrayList<>());
        addCourse("CS102", 2, new ArrayList<>(Arrays.asList("CS101")));

        register("S1", "CS101");
        register("S2", "CS101");
        register("S3", "CS101");

        register("S1", "CS102");
        register("S2", "CS102");

        drop("S1", "CS101");

        display("CS101");
        display("CS102");
    }
}