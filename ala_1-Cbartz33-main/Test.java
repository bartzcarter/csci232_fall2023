/**
 * Class to Test the class Person and those that extend it
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: January 24, 2023
 * Last date modified: January 24, 2023
 */

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Person("Helen Brown", "222 10th Street Bethlehem", "610-334-2288", "hbrown@gmail.com");
        people[1] = new Student("Paul Leister", "972 4th Street Allentown", "610-331-7177", "pleister@gmail.com", 12345,
                "CSE");
        people[2] = new Employee("Beth Down", "234 Main Street Philadelphia", "484-222-4433", "bdown@gmail.com", 33442,
                "Systems Administrator", 75000.00);
        people[3] = new Faculty("Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211", "mjones@gmail.com", 22222,
                "Faculty", 100000.00, "Associate Professor");

        printArray(people);
        sortArray(people);
        System.out.println("Sorted List:");
        System.out.println();
        printArray(people);
    }

    public static void printArray(Person[] list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public static void sortArray(Person[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j].getName().compareTo(list[minIndex].getName()) < 0)
                    minIndex = j;
            Person temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

}