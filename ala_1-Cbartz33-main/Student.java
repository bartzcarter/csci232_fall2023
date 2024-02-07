/**
 * class to model the entity Student
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: Jan 24, 2023
 * Last date modified: jan 24, 2023
 */
public class Student extends Person {
    // data members
    private int id;
    private String major;

    /**
     * Default constructor
     * No parameters
     * Initializes id, and major to null and 0
     */
    public Student() {
        super();
        this.id = 0;
        this.major = "null";
    }

    /**
     * Constructor with 6 parameters
     * @param name   for the name of the student
     * @param adress for the adress of the student
     * @param phone  for the phone number of the student
     * @param email  for the email of the student
     * @param id     for the id of the student
     * @param major  for the major of the student
     */
    public Student(String name, String adress, String phone, String email, int id, String major) {
        super(name, adress, phone, email);
        this.id = id;
        this.major = major;
    }

    /**
     * Getter method for the id
     * @param none
     * @return the integer value of the id
     */
    public int getID() {
        return this.id;
    }

    /**
     * Getter method for the major
     * @param none
     * @return the string value of major
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * Setter method for the student id
     * @param id to set the data member id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter method for the student major
     * @param m to set the data member major
     */
    public void setMajor(String m) {
        this.major = m;
    }

    /**
     * Overriden method for the toString() method to get student information
     * @param none
     * @return formatted string containing the data members
     */
    @Override
    public String toString() {
        return String.format("%s\nID: %d\nMajor: %s", super.toString(), id, major);
    }
}