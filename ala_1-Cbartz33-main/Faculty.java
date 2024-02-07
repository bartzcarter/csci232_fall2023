/**
 * class to model the entity Faculty
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: Jan 24, 2023
 * Last date modified: jan 24, 2023
 */
public class Faculty extends Employee {
    // data members
    private String rank;

    /**
     * Default constructor
     * No parameters
     * Initializes rank to null
     */
    public Faculty() {
        super();
        this.rank = "null";
    }

    /**
     * Constructor with 8 parameters
     * @param name     for the name of the faculty member
     * @param adress   for the adress of the faculty member
     * @param phone    for the phone number of the faculty member
     * @param email    for the email of the faculty member
     * @param id       for the id of the faculty member
     * @param position for the position of the faculty member
     * @param salary   for the salary of the faculty member
     * @param rank     for the rank of the faculty memeber
     */
    public Faculty(String name, String adress, String phone, String email, int id, String position, double salary,
            String rank) {
        super(name, adress, phone, email, id, position, salary);
        this.rank = rank;
    }

    /**
     * Getter method for the rank
     * @param none
     * @return the string value of the rank
     */
    public String getRank() {
        return this.rank;
    }

    /**
     * Setter method for the faculty rank
     * @param rank to set the data member rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Overriden method for the toString() method to get faculty information
     * @param none
     * @return formatted string containing the data members
     */
    @Override
    public String toString() {
        return String.format("%s\nRank: %s\n", super.toString(), rank);
    }
}