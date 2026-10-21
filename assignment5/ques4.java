import java.time.*;
import java.util.*;

public class ques4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = sc.nextLine();

        System.out.print("Enter event date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:mm): ");
        LocalTime time = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (or leave empty): ");
        String venue = sc.nextLine();

        Optional<String> v = venue.isEmpty() ? Optional.empty() : Optional.of(venue);

        System.out.println("\nEvent Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + time);
        System.out.println("Venue: " + v.orElse("Venue not specified"));
        System.out.println("End Time: " + time.plusHours(2));

        LocalDate today = LocalDate.now();

        if (date.isAfter(today)) {
            System.out.println("Event is in the future");
        } else if (date.isEqual(today)) {
            System.out.println("Event is today");
        } else {
            System.out.println("Event is in the past");
        }

        long days = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days remaining: " + days);

        sc.close();
    }
}