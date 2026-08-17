package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.util.InputValidator;
import library.service.LibraryService;

public class Main {

    public static void main(String[] args) {

        LibraryResource[] resources = new LibraryResource[5];

        int[] overdueDays = {2, 5, 0, 3, 4};

        resources[0] = new Book(101, "Java Programming", "James Gosling");
        resources[1] = new DigitalResource(102, "Database Systems", "Raghu Ramakrishnan");
        resources[2] = new Book(103, "Operating Systems", "Galvin");
        resources[3] = new DigitalResource(104, "Computer Networks", "Andrew Tanenbaum");
        resources[4] = new Book(105, "Data Structures", "Mark Allen");

        System.out.println("Library: " + LibraryResource.libraryName);
        System.out.println();

        for (int i = 0; i < resources.length; i++) {

            if (InputValidator.validateResourceId(resources[i].getResourceId())
                    && InputValidator.validateFineDays(overdueDays[i])) {

                ((library.model.Printable) resources[i]).printDetails();

                System.out.println("Overdue Days: " + overdueDays[i]);
                System.out.println("Fine: Rs. " +
                        resources[i].calculateFine(overdueDays[i]));

                System.out.println("-----------------------------");
            }
        }

        double totalFine =
                LibraryService.calculateTotalFine(resources, overdueDays);

        System.out.println("Total Fine: Rs. " + totalFine);

        LibraryResource.displayTotalResources();
    }
}